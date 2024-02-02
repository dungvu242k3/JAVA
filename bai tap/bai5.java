
import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin cho ma trận A
        System.out.println("Nhập thông tin cho ma trận A:");
        int[][] matrixA = nhapMaTran(scanner);

        // Nhập thông tin cho ma trận B
        System.out.println("Nhập thông tin cho ma trận B:");
        int[][] matrixB = nhapMaTran(scanner);

        // In nội dung của ma trận A
        System.out.println("Ma trận A:");
        inMaTran(matrixA);

        // In nội dung của ma trận B
        System.out.println("Ma trận B:");
        inMaTran(matrixB);

        // Tính tích của ma trận A và B
        int[][] resultMatrix = tinhTichMaTran(matrixA, matrixB);

        // In nội dung của ma trận tích
        System.out.println("Tích của ma trận A và B:");
        inMaTran(resultMatrix);

        scanner.close();
    }

    // Hàm nhập thông tin cho một ma trận
    public static int[][] nhapMaTran(Scanner scanner) {
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Nhập phần tử tại vị trí [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    // Hàm in nội dung của một ma trận
    public static void inMaTran(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Hàm tính tích của hai ma trận
    public static int[][] tinhTichMaTran(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int columnsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int columnsB = matrixB[0].length;

        if (columnsA != rowsB) {
            System.out.println("Không thể nhân hai ma trận với kích thước không phù hợp.");
            return null;
        }

        int[][] resultMatrix = new int[rowsA][columnsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }
}
