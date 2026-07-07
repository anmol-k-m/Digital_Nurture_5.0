package EX_04;

class Employee {

    private final int employeeId;
    private String employeeName;
    private String department;
    private double salary;

    public Employee(int employeeId, String employeeName, String department, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
                ", Name: " + employeeName +
                ", Department: " + department +
                ", Salary: " + salary;
    }
}

class EmployeeArrayManager {

    private final Employee[] employees;
    private int size;

    public EmployeeArrayManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size == employees.length) {
            return false;
        }

        employees[size] = employee;
        size++;
        return true;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public boolean updateEmployee(int employeeId, String name, String department, double salary) {
        Employee employee = searchEmployee(employeeId);
        if (employee == null) {
            return false;
        }

        employee.setEmployeeName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        return true;
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public void displayEmployees() {
        if (size == 0) {
            System.out.println("No employee records available.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        EmployeeArrayManager manager = new EmployeeArrayManager(5);

        manager.addEmployee(new Employee(101, "Anita Rao", "HR", 45000.00));
        manager.addEmployee(new Employee(102, "Rahul Mehta", "IT", 60000.00));
        manager.addEmployee(new Employee(103, "Priya Nair", "Finance", 55000.00));

        System.out.println("Initial Employee Records:");
        manager.displayEmployees();

        System.out.println("\nSearching for employee 102:");
        Employee employee = manager.searchEmployee(102);
        System.out.println(employee != null ? employee : "Employee not found.");

        System.out.println("\nUpdating employee 103:");
        System.out.println(manager.updateEmployee(103, "Priya Nair", "Accounts", 58000.00)
                ? "Employee updated successfully."
                : "Employee not found.");

        System.out.println("\nDeleting employee 101:");
        System.out.println(manager.deleteEmployee(101) ? "Employee deleted successfully." : "Employee not found.");

        System.out.println("\nFinal Employee Records:");
        manager.displayEmployees();

        System.out.println("\nAnalysis:");
        System.out.println("- Arrays store employee records in contiguous memory locations.");
        System.out.println("- Search is O(n) because each employee may need to be checked sequentially.");
        System.out.println("- Insertions and deletions can be costly because elements must be shifted.");
        System.out.println("- Arrays have fixed size, so capacity must be decided in advance.");
        System.out.println("- Use arrays when the number of records is known, access is mostly sequential, and data size is small or stable.");
        System.out.println("- Avoid arrays when the dataset grows frequently or requires many insert/delete operations; dynamic structures like ArrayList are usually better.");
    }
}
