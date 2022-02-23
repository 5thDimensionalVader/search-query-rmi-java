import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import javax.rmi.ssl.*;


/* 
  This is the implementation of the Search interface.
*/

public class SearchQuery extends UnicastRemoteObject implements Search {

  protected SearchQuery() throws RemoteException {
    super(0, new SslRMIClientSocketFactory(), new SslRMIServerSocketFactory(null, null, true));
  }

  // remote interface 'Search' method 'query()' implementation
  public String query (String search) throws RemoteException, Exception {
    String product;
    String result;
    boolean queryExists;

    // get the filename from path
    Path fileName = Path.of("prod.txt");

    // read into the product string
    product = Files.readString(fileName);

    // check if the search exists in the string
    queryExists = product.contains(search);

      if(queryExists){
        result = "EXIST";
      } else {
        result = "!EXIST";
      }

    return result;
  }
}