
import java.util.Scanner;

public class Cylinder extends Circle {

    private double height;

    // Constructor
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    // Getter and setter for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Method to check if it is a cylinder
    public boolean isCylinder() {
        return height > 0;
    }

    // Method to calculate lateral surface area
    public double calculateLateralSurfaceArea() {
        if (isCylinder()) {
            return super.calculateCircumference() * height;
        } else {
            return -1; // Invalid, not a cylinder
        }
    }

    // Method to calculate total surface area
    public double calculateTotalSurfaceArea() {
        if (isCylinder()) {
            return super.calculateArea() + calculateLateralSurfaceArea();
        } else {
            return -1; // Invalid, not a cylinder
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input radius for the circle base
        System.out.print("Enter the radius of the circle base for the cylinder: ");
        double radiusInput = scanner.nextDouble();

        // Input height for the cylinder
        System.out.print("Enter the height of the cylinder: ");
        double heightInput = scanner.nextDouble();

        scanner.close();

        // Create a Cylinder object
        Cylinder myCylinder = new Cylinder(radiusInput, heightInput);

        // Display results
        System.out.println("\nIs Cylinder? " + myCylinder.isCylinder());
        System.out.println("Radius: " + myCylinder.getBk());
        System.out.println("Height: " + myCylinder.getHeight());

        if (myCylinder.isCylinder()) {
            System.out.println("Lateral Surface Area: " + myCylinder.calculateLateralSurfaceArea());
            System.out.println("Total Surface Area: " + myCylinder.calculateTotalSurfaceArea());
        } else {
            System.out.println("Invalid cylinder. Please enter valid dimensions.");
        }
    }
}
