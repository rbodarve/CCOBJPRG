class Employee {
    private String name;
    private int employeeID;
    private double years;
    
    public Employee(String name, int employeeID, double years) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (employeeID < 0) {
            throw new IllegalArgumentException("Employee ID cannot be negative");
        }
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        this.name = name;
        this.employeeID = employeeID;
        this.years = years;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getEmployeeID() {
        return employeeID;
    }
    
    public double getYears() {
        return years;
    }
    
    public double calculateBaseSalary(double baseMultiplier, double baseAddition) {
        return years * baseMultiplier + baseAddition;
    }
}
 
class Professor extends Employee {
    private static final double BASE_MULTIPLIER = 10000;
    private static final double BASE_ADDITION = 25000;
    private String dept;
    
    public Professor(String name, int employeeID, double years, String dept) {
        super(name, employeeID, years);
        this.dept = dept;
    }
    
    @Override
    public String toString() {
        double baseSalary = calculateBaseSalary(BASE_MULTIPLIER, BASE_ADDITION);
        return String.format("Professor: %s\nEmployee ID: %d\nDepartment: %s\nSalary: $%.2f\n", 
                             getName(), getEmployeeID(), dept, baseSalary);
    }
}
 
class AdministrativeStaff extends Employee {
    private static final double BASE_MULTIPLIER = 8000;
    private static final double BASE_ADDITION = 13000;
    private String role;
    
    public AdministrativeStaff(String name, int employeeID, double years, String role) {
        super(name, employeeID, years);
        this.role = role;
    }
    
    @Override
    public String toString() {
        double baseSalary = calculateBaseSalary(BASE_MULTIPLIER, BASE_ADDITION);
        return String.format("Administrative Staff: %s\nEmployee ID: %d\nRole: %s\nSalary: $%.2f\n", 
                             getName(), getEmployeeID(), role, baseSalary);
    }
}
 
// Driver Class
public class empInherit {
    public static void main(String[] args) {
        Professor a = new Professor("John Doe", 0, 3, "Computer Science");
        AdministrativeStaff b = new AdministrativeStaff("Jane Smith", 1, 3, "Secretary");
        
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }
}
