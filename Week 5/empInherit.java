class Employee {
    String name;
    private int employeeID;
    private double years;
    
    public Employee(String name, int employeeID, double years) {
this.name = name;
        this.employeeID = employeeID;
        this.years = years;
    }
 
    // Getters and setters if needed
    
    public double calculateBaseSalary(double baseMultiplier, double baseAddition) {
        return years * baseMultiplier + baseAddition;
    }
}
 
class Professor extends Employee {
    private String dept;
 
    public Professor(String name, int employeeID, double years, String dept) {
        super(name, employeeID, years);
        this.dept = dept;
    }
 
    public void print() {
        double baseSalary = calculateBaseSalary(10000, 25000);
        System.out.printf("Professor: %s\nDepartment: %s\nSalary: $%.2f\n\n", name, dept, baseSalary);
    }
}
 
class AdministrativeStaff extends Employee {
    private String role;
 
    public AdministrativeStaff(String name, int employeeID, double years, String role) {
        super(name, employeeID, years);
        this.role = role;
    }
 
    public void print() {
        double baseSalary = calculateBaseSalary(8000, 13000);
        System.out.printf("Administrative Staff: %s\nRole: %s\nSalary: $%.2f\n\n", name , role, baseSalary);
    }
}
 
// Driver Class
public class empInherit {
    public static void main(String[] args) {
        Professor a = new Professor("John Doe", 0, 3, "Computer Science");
        AdministrativeStaff b = new AdministrativeStaff("Jane Smith", 1, 3, "Secretary");
 
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        a.print();
        b.print();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }
}
