
import java.util.Scanner;

class Circle {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public boolean isCircle() {
        return true;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Cylinder extends Circle {

    double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public boolean isCircle() {
        return false;
    }

    public double calculateSurfaceArea() {
        // Diện tích xung quanh của hình trụ
        return super.calculatePerimeter() * height + 2 * super.calculateArea();
    }

    public double calculateVolume() {
        // Diện tích toàn phần của hình trụ
        return super.calculateArea() * height;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập bán kính của hình trụ: ");
        double radius = scanner.nextDouble();

        System.out.print("Nhập chiều cao của hình trụ: ");
        double height = scanner.nextDouble();

        Cylinder cylinder = new Cylinder(radius, height);

        System.out.println("Is Circle: " + !cylinder.isCircle()); // Phải in ra false
        System.out.println("Surface Area: " + cylinder.calculateSurfaceArea());
        System.out.println("Volume: " + cylinder.calculateVolume());

        scanner.close();
    }
}
