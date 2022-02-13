import java.rmi.*;
import java.rmi.registry.*;
/* 
  This is the server.
 */

public class Server {
  public static void main (String ... args) throws RemoteException, Exception{
    SearchQuery stub = new SearchQuery();
    Registry registry = LocateRegistry.createRegistry(1099);
    System.out.println("🟢 registry mechanism created and started ...");
    Naming.rebind("query", stub);
    System.out.println("🟢 server started ... ");
  }
}