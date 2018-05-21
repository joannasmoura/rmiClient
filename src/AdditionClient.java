import java.rmi.Naming;
import java.util.Scanner;

public class AdditionClient {
	public static void main(String[] args) {
		final AdditionInterface methods;
		int[][] sumResult;
		Boolean flag = false;
		Scanner s = new Scanner(System.in);
		try {
			methods = (AdditionInterface) Naming.lookup("rmi://localhost/ABC");
			while (flag == false) {
				System.out.println("Para realizar operações com matrizes digite 1");
				System.out.println("Para realizar operações com vetores digite 2");
				int escolha = s.nextInt();
				if (escolha == 1) {
					System.out.println("Digite 1 para soma de matrizes e 2 para subtração");
					int opt = s.nextInt();
					if(opt == 1) {
						sumResult = methods.matrixSum();
						System.out.println("A soma das duas matrizes é:");
						int[][] oia = new int[2][3];
						for (int i = 0; i < 2; i++) {
							for (int j = 0; j < 3; j++) {
								System.out.print(sumResult[i][j] + " ");
							}
							System.out.println();
						}
					} else if(opt == 2) {
						sumResult = methods.matrixSubtract();
						System.out.println("A subtração das duas matrizes é:");
						int[][] oia = new int[2][3];
						for (int i = 0; i < 2; i++) {
							for (int j = 0; j < 3; j++) {
								System.out.print(sumResult[i][j] + " ");
							}
							System.out.println();
						}
					}
				} else if (escolha == 2) {
					System.out.println("Digite 1 para vetor escalar e 2 para soma de vetores: ");
					int opt = s.nextInt();
					if(opt == 1) {
						System.out.print("Digite o tamanho do array:  ");
						int tamanho = s.nextInt();
						double[] array = new double[tamanho];
						for (int x = 0; x < tamanho; x++) {
							System.out.println("digite o valor de posição " + x + ": ");
							array[x] = s.nextDouble();
						}
						System.out.println("Digite a escala: ");
						double scale = s.nextDouble();
						methods.arrayScalar(array, scale);
					}else if(opt == 2) {
						System.out.print("Digite o tamanho dos arrays:  ");
						int tamanho = s.nextInt();
						double[] array1 = new double[tamanho];
						double[] array2 = new double[tamanho];
						System.out.println("Array 1: ");
						for (int x = 0; x < tamanho; x++) {
							System.out.println("digite o valor de posição " + x + ": ");
							array1[x] = s.nextDouble();
						}
						System.out.println("Array 2: ");
						for (int x = 0; x < tamanho; x++) {
							System.out.println("digite o valor de posição " + x + ": ");
							array2[x] = s.nextDouble();
						}
						System.out.println("Soma dos dois arrays: ");
						methods.arraySum(array1, array2);
					}
					
				} else {
					System.out.println("Escolha uma opção válida!");
				}
			}

		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}