
import java.util.Scanner;

public class ConvertBase {

    public static void main(String[] args) {
        int n = inputInteger("Nhập giá trị nguyên dương n: ");
        int k = inputK("Nhập số k thỏa mãn 2 <= k <= 16: ");
        System.out.println("Giá trị sau khi chuyển đổi từ cơ số 10 sang cơ số " + k + ": " + convertBase(n, k));
    }

    public static int inputInteger(String message) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(message);
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    throw new Exception();
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return n;
    }

    public static int inputK(String message) {
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(message);
            try {
                k = Integer.parseInt(scanner.nextLine());
                if (k < 2 || k > 16) {
                    throw new Exception();
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return k;
    }

    public static String convertBase(int n, int k) {
        return Integer.toString(n, k);
    }
}
