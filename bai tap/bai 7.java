
import java.util.Scanner;

class Employee {

    // Các thuộc tính của nhân viên
    private String fullName;
    private String hometown;
    private String gender;
    private double salaryLevel;
    private String position;
    private String educationLevel;

    // Constructor mặc định
    public Employee() {
    }

    // Constructor với tham số
    public Employee(String fullName, String hometown, String gender, double salaryLevel, String position, String educationLevel) {
        this.fullName = fullName;
        this.hometown = hometown;
        this.gender = gender;
        this.salaryLevel = salaryLevel;
        this.position = position;
        this.educationLevel = educationLevel;
    }

    // Phương thức tính lương
    public double calculateSalary() {
        // Nếu là quản lý, hệ số lương là 2, ngược lại là 1
        return (position.equalsIgnoreCase("Quản lý")) ? 2 * salaryLevel : salaryLevel;
    }

    // Phương thức tính lương theo hệ số lương
    public double calculateSalaryByCoefficient(double coefficient) {
        return coefficient * salaryLevel;
    }

    // Phương thức hiển thị thông tin nhân viên
    public void displayInfo(double coefficient) {
        System.out.println("Ho ten: " + fullName);
        System.out.println("Que quan: " + hometown);
        System.out.println("Gioi tinh: " + gender);
        System.out.println("Mức Lương: " + salaryLevel);
        System.out.println("Chuc vu: " + position);
        System.out.println("Trinh do: " + educationLevel);
        System.out.println("Luong: " + calculateSalary());
        System.out.println("Luong theo he so: " + calculateSalaryByCoefficient(coefficient));
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo danh sách nhân viên
        Employee[] employees = new Employee[2];

        // Nhập thông tin cho từng nhân viên
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.print("Họ và tên: ");
            String fullName = scanner.nextLine();
            System.out.print("Quê quán: ");
            String hometown = scanner.nextLine();
            System.out.print("Giới tính: ");
            String gender = scanner.nextLine();
            System.out.print("Mức Lương: ");
            double salaryLevel = scanner.nextDouble();
            scanner.nextLine(); // Đọc dòng trống
            System.out.print("Chức vụ: ");
            String position = scanner.nextLine();
            System.out.print("Trình độ: ");
            String educationLevel = scanner.nextLine();
            System.out.print("Nhập hệ số lương: ");
            double coefficient = scanner.nextDouble();
            scanner.nextLine(); // Đọc dòng trống

            // Tạo đối tượng nhân viên và thêm vào danh sách
            employees[i] = new Employee(fullName, hometown, gender, salaryLevel, position, educationLevel);

            // Hiển thị thông tin của nhân viên
            System.out.println("Thông tin nhân viên:");
            employees[i].displayInfo(coefficient);
        }
    }
}
