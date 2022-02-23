import java.rmi.*;
import java.rmi.registry.*;
import javax.rmi.ssl.*;
/* 
  This is the server.
 */

public class Server {
  public static void main (String ... args) throws RemoteException, Exception{
    // constant value for the port number for the connection.
    final int PORT = 6545;

    Registry registry = LocateRegistry.createRegistry(PORT, new SslRMIClientSocketFactory(), new SslRMIServerSocketFactory(null, null, true));
    SearchQuery stub = new SearchQuery();
    System.out.println("🟢 registry mechanism created and started ...");
    registry.bind("query", stub);
    System.out.println("🟢 server started ... ");
  }
}