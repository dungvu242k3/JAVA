
import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị n từ bàn phím
        System.out.print("Nhập giá trị n (n >= 1): ");
        int n = scanner.nextInt();

        // Kiểm tra điều kiện n
        if (n < 1) {
            System.out.println("Giá trị của n không hợp lệ.");
            return;
        }

        int[][] magicSquare = generateMagicSquare(n);
        t // In ma trận vuông kết quả
                printMatrix(magicSquare

    
    );
    }

    public static int[][] generateMagicSquare(int n) {
        int[][] magicSquare = new int[n][n];

        int i = n / 2;
        int j = n - 1;

        int num = 1;
        int totalSum = n * (n * n + 1) / 2;

        while (num <= n * n) {
            if (i == -1 && j == n) {
                j = n - 2;
                i = 0;
            } else {
                if (j == n) {
                    j = 0;
                }
                if (i < 0) {
                    i = n - 1;
                }
            }

            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            } else {
                magicSquare[i][j] = num++;
            }

            j++;
            i--;
        }

        return magicSquare;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
