import java.rmi.*;

public interface AdditionInterface extends Remote {
	public int add(int a,int b) throws RemoteException;
	
	public int[][] matrixSum() throws RemoteException;
	
	public int[][] matrixSubtract() throws RemoteException;
}