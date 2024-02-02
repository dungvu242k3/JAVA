
import java.util.Scanner;

public class Circle {

    private double bk;

    // Constructor
    public Circle(double radius) {
        this.bk = radius;
    }

    // Getter and setter for radius
    public double getBk() {
        return bk;
    }

    public void setBk(double radius) {
        this.bk = radius;
    }

    // Method to check if it is a circle
    public boolean isCircle() {
        return bk > 0;
    }

    // Method to calculate area
    public double calculateArea() {
        if (isCircle()) {
            return Math.PI * Math.pow(bk, 2);
        } else {
            return -1; // Invalid, not a circle
        }
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        if (isCircle()) {
            return 2 * Math.PI * bk;
        } else {
            return -1; // Invalid, not a circle
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input radius from the user
        System.out.print("Nhập bán kính hình tròn: ");
        double radiusInput = scanner.nextDouble();

        scanner.close();

        Circle myCircle = new Circle(radiusInput);

        System.out.println("Có phải hình tròn không? " + myCircle.isCircle());
        System.out.println("Bán kính: " + myCircle.getBk());

        if (myCircle.isCircle()) {
            System.out.println("Diện tích: " + myCircle.calculateArea());
            System.out.println("Chu vi: " + myCircle.calculateCircumference());
        } else {
            System.out.println("Không phải hình tròn");
        }
    }
}
