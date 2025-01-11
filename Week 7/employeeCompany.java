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

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + 50;
    }
}

class Executive extends Employee {
    public Executive(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + 100;
    }
}

class Company {
    private Employee[] employees;

    public Company() {
        employees = new Employee[5];
    }

    public void inputEmployeeDetails() {
        Set<String> enteredNames = new HashSet<>();
        Set<String> enteredTypes = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            String name;
            String type;
            boolean nameTypeExists;

            do {
                name = JOptionPane.showInputDialog(null, 
                        "Enter name for Employee " + (i + 1) + ":");
                type = (String) JOptionPane.showInputDialog(null, 
                        "Select employee type for " + name, "Employee Type", 
                        JOptionPane.QUESTION_MESSAGE, null, 
                        new String[]{"Regular", "Manager", "Executive"}, 
                        "Regular");

                nameTypeExists = enteredNames.contains(name) && enteredTypes.contains(type);
                if (nameTypeExists) {
                    JOptionPane.showMessageDialog(null, 
                            "Employee with the same name and type already exists. Please enter again.", ""
                                    + "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
                }
            } while (nameTypeExists);

            enteredNames.add(name);
            enteredTypes.add(type);

            double baseSalary = 100; // Default base salary for all types
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

public class employeeCompany {
    public static void main(String[] args) {
        Company company = new Company();
        company.inputEmployeeDetails();
        JOptionPane.showMessageDialog(null, "Total Salary: $" + 
                company.totalSalary(), "Total Salary", 
                JOptionPane.INFORMATION_MESSAGE);
        company.displayInfo();
    }
}
