import java.rmi.Naming;
 
public class AdditionClient {
	public static void main (String[] args) {
		AdditionInterface hello;
		int[][] sumResult;
		try {
			hello = (AdditionInterface)Naming.lookup("rmi://localhost/ABC");
			sumResult = hello.matrixSum();
			System.out.println("A soma das duas matrizes é:");
			int[][] oia = new int[2][3];
		       for (int i = 0; i < 2; i++) {
		           for (int j = 0; j < 3; j++) {
		               System.out.print(sumResult[i][j] + " ");  
		           }
		           System.out.println();
		       }
			}catch (Exception e) {
				System.out.println("HelloClient exception: " + e);
				}
		}
}