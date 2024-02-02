import java.util.Scanner;

abstract class AbShape {
    abstract double perimeter();
    abstract double area();
    abstract double volume();
    double totalArea() {
        return area();
    }
}

class Circle extends AbShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double volume() {
        return 0; // Circle has no volume
    }
}

class Rectangle extends AbShape {
    private double length;
    private double width;
    private double height;

    public Rectangle(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double volume() {
        return length * width * height;
    }

    @Override
    double totalArea() {
        return 2 * (area() + length * height + width * height);
    }
}

public class TestAbstractClass01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập bán kính hình tròn: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double length = scanner.nextDouble();
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double width = scanner.nextDouble();
        System.out.print("Nhập chiều cao hình chữ nhật: ");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(length, width, height);

        System.out.println("\nCircle Perimeter: " + circle.perimeter());
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Total Area: " + circle.totalArea());
        System.out.println("Circle Volume: " + circle.volume());

        System.out.println("\nRectangle Perimeter: " + rectangle.perimeter());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Total Area: " + rectangle.totalArea());
        System.out.println("Rectangle Volume: " + rectangle.volume());

        scanner.close();
    }
}
