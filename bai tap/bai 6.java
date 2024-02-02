
import java.util.Scanner;

public class Employee {

    private String name;
    private String hometown;
    private String gender;
    private double salary;
    private String position;
    private String level;

    public Employee(String name, String hometown, String gender, double salary, String position, String level) {
        this.name = name;
        this.hometown = hometown;
        this.gender = gender;
        this.salary = salary;
        this.position = position;
        this.level = level;
    }

    public double calculateSalary() {
        if (position.equals("Manager")) {
            return salary * 2;
        } else {
            return salary;
        }
    }

    public void displayEmployee() {
        System.out.println("Name: " + name);
        System.out.println("Hometown: " + hometown);
        System.out.println("Gender: " + gender);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("Position: " + position);
        System.out.println("Level: " + level);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Hometown: ");
            String hometown = scanner.nextLine();

            System.out.print("Gender: ");
            String gender = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // consume newline left-over

            System.out.print("Position: ");
            String position = scanner.nextLine();

            System.out.print("Level: ");
            String level = scanner.nextLine();

            employees[i] = new Employee(name, hometown, gender, salary, position, level);
        }

        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }
}
