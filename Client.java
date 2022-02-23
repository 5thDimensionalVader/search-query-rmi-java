import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import javax.rmi.ssl.*;

/*
  This is the client.
 */

public class Client {
  public static void main(String... args) throws RemoteException, Exception {
    // constant value for the port number for the connection.
    final int PORT = 6545;

    // create registry
    Registry registry = LocateRegistry.getRegistry(null,PORT, new SslRMIClientSocketFactory());
    Search obj = (Search) registry.lookup("query");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter name of product: ");
    String search = scanner.nextLine();

    

    String query = obj.query(search);
    // check the return value of query
    if(query.equals("EXIST")){
      File newFile = new File("client_product.txt");
      String fileName = newFile.getName();
      boolean isNewFile = newFile.createNewFile();
      FileWriter writer = new FileWriter(fileName, true);

      if(isNewFile){
        System.out.println("📂 new file created, file name: " + fileName);
        writer.write(search);
        System.out.println("🟢 product added to file ...");
        writer.close();
      } else {
        System.out.println("🟡 file already exists: " + fileName);
        if (newFile.length() == 0){
          writer.write(search);
          System.out.println("🟢 product added to file ...");
          writer.close();
        } else {
          writer.write("\n"+search);
          System.out.println("🟢 product added to file ...");
          writer.close();
        }
      }
    } else if (query.equals("!EXIST")){
      System.out.println("🚫 product doesn't exist!");
      System.exit(0);
    }
  }
}