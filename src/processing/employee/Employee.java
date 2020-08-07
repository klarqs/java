package processing.employee;

public class Employee {

    private String firstName;
    private String color;
    private double salary;
    private String department;

    public Employee (String firstName, String color, double salary, String department){
        this.firstName = firstName;
        this.color = color;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
        public String toString() {
            return String.format("%-8s %-8s %8.2f  %s",
                    getFirstName(), getColor(), getSalary(), getDepartment());
    }
}