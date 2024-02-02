
import java.util.Scanner;

public class TinhTichHaiMaTran {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước của mảng A
        System.out.print("Nhập số hàng của mảng A: ");
        int hangA = scanner.nextInt();
        System.out.print("Nhập số cột của mảng A: ");
        int cotA = scanner.nextInt();

        // Nhập kích thước của mảng B
        System.out.print("Nhập số hàng của mảng B: ");
        int hangB = scanner.nextInt();
        System.out.print("Nhập số cột của mảng B: ");
        int cotB = scanner.nextInt();

        // Kiểm tra có thể nhân hai ma trận hay không
        if (cotA != hangB) {
            System.out.println("Không thể nhân hai ma trận với số cột của ma trận A khác số hàng của ma trận B.");
            return;
        }

        // Nhập mảng A
        int[][] a = nhapMaTran("A", hangA, cotA);

        // Nhập mảng B
        int[][] b = nhapMaTran("B", hangB, cotB);

        // Tính tích của hai mảng và in kết quả
        int[][] ketQua = tinhTichMaTran(a, b);
        if (ketQua != null) {
            inMaTran("Kết quả", ketQua);
        }
    }

    // Hàm nhập mảng từ người dùng
    public static int[][] nhapMaTran(String ten, int hang, int cot) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mảng " + ten + ":");
        int[][] maTran = new int[hang][cot];
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print("Nhập phần tử [" + i + "][" + j + "]: ");
                maTran[i][j] = scanner.nextInt();
            }
        }
        return maTran;
    }

    // Hàm tính tích của hai mảng
    public static int[][] tinhTichMaTran(int[][] a, int[][] b) {
        int hangA = a.length;
        int cotA = a[0].length;
        int cotB = b[0].length;

        int[][] ketQua = new int[hangA][cotB];

        for (int i = 0; i < hangA; i++) {
            for (int j = 0; j < cotB; j++) {
                for (int k = 0; k < cotA; k++) {
                    ketQua[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return ketQua;
    }

    // Hàm in mảng
    public static void inMaTran(String ten, int[][] maTran) {
        System.out.println("Ma trận " + ten + ":");
        for (int i = 0; i < maTran.length; i++) {
            for (int j = 0; j < maTran[0].length; j++) {
                System.out.print(maTran[i][j] + " ");
            }
            System.out.println();
        }
    }
}
