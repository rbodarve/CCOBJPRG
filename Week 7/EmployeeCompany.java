import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

class RegularEmployee extends Employee {
    public RegularEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }
}

class Manager extends Employee {
    private static final double MANAGER_BONUS = 500.0;
    
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * 1.10 + MANAGER_BONUS;
    }
}

class Executive extends Employee {
    private static final double EXECUTIVE_BONUS = 1000.0;
    
    public Executive(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * 1.20 + EXECUTIVE_BONUS;
    }
}

class Company {
    private Employee[] employees;

    public Company() {
        employees = new Employee[5];
    }

    public void inputEmployeeDetails() {
        Set<String> enteredNameTypePairs = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            String name = "";
            String type = "";
            String nameTypePair = "";
            boolean nameTypeExists = false;

            do {
                name = JOptionPane.showInputDialog(null, 
                        "Enter name for Employee " + (i + 1) + ":");
                
                if (name == null) {
                    JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", 
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                if (name.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name cannot be empty. Please try again.", "Invalid Input", 
                            JOptionPane.ERROR_MESSAGE);
                    nameTypeExists = true;
                    continue;
                }
                
                type = (String) JOptionPane.showInputDialog(null, 
                        "Select employee type for " + name, "Employee Type", 
                        JOptionPane.QUESTION_MESSAGE, null, 
                        new String[]{"Regular", "Manager", "Executive"}, 
                        "Regular");

                if (type == null) {
                    JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", 
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                nameTypePair = name + "-" + type;
                nameTypeExists = enteredNameTypePairs.contains(nameTypePair);
                
                if (nameTypeExists) {
                    JOptionPane.showMessageDialog(null, 
                            "Employee with the same name and type already exists. Please enter again.", 
                            "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
                }
            } while (nameTypeExists);

            enteredNameTypePairs.add(nameTypePair);

            String baseSalaryInput = JOptionPane.showInputDialog(null, 
                    "Enter base salary for " + name + ":", "5000");
            double baseSalary = 5000;
            try {
                baseSalary = Double.parseDouble(baseSalaryInput);
                if (baseSalary < 0) {
                    JOptionPane.showMessageDialog(null, "Salary cannot be negative. Using default: 5000", 
                            "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    baseSalary = 5000;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid salary input. Using default: 5000", 
                        "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
            
            switch (type) {
                case "Regular":
                    employees[i] = new RegularEmployee(name, baseSalary);
                    break;
                case "Manager":
                    employees[i] = new Manager(name, baseSalary);
                    break;
                case "Executive":
                    employees[i] = new Executive(name, baseSalary);
                    break;
                default:
                    employees[i] = new RegularEmployee(name, baseSalary);
            }
        }
    }


    public double totalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }
        return total;
    }

    public void displayInfo() {
        StringBuilder info = new StringBuilder();
        for (Employee employee : employees) {
            info.append("Employee Name: ").append(employee.getName()).append("\n");
            info.append("Base Salary: $").append(employee.getBaseSalary()).append("\n");
            info.append("Total Salary: $").append(employee.calculateSalary()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, info.toString(), 
                "Employee Information", JOptionPane.INFORMATION_MESSAGE);
    }
}

public class EmployeeCompany {
    public static void main(String[] args) {
        Company company = new Company();
        company.inputEmployeeDetails();
        JOptionPane.showMessageDialog(null, "Total Salary: $" + 
                company.totalSalary(), "Total Salary", 
                JOptionPane.INFORMATION_MESSAGE);
        company.displayInfo();
    }
}
