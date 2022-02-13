import java.rmi.Remote;
import java.rmi.RemoteException;

/*
  This is the remote interface, that will give a description of the method(s) that can be invoked by remote clients.

 */
public interface Search extends Remote {
  // define method
  public String query (String search) throws RemoteException, Exception;
}