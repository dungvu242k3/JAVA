
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập giá trị nguyên dương n
        int n;
        do {
            System.out.print("Nhập vào giá trị nguyên dương n: ");
            n = scanner.nextInt();
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
        } while (n <= 0);

        // Bước 2: Nhập số k thỏa mãn 2 <= k <= 16
        int k;
        do {
            System.out.print("Nhập vào giá trị k (2 <= k <= 16): ");
            k = scanner.nextInt();
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
        } while (k < 2 || k > 16);

        // Bước 3: Chuyển n từ cơ số 10 sang cơ số k
        String result = convertBase(n, k);

        System.out.println("Kết quả chuyển đổi từ cơ số 10 sang cơ số " + k + " là: " + result);
    }

    // Hàm chuyển đổi từ cơ số 10 sang cơ số k
    public static String convertBase(int n, int k) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int remainder = n % k;

            if (remainder < 10) {
                result.append(remainder);
            } else {
                result.append((char) (remainder + 55));
            }

            n /= k;
        }

        return result.reverse().toString();
    }
}
