public class Employee implements CsvEntity{
    public int id;
    public String fullName;
    public String department;
    public double salary;

    public Employee(String department, String fullName, int id, double salary) {
        this.department = department;
        this.fullName = fullName;
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toCsvRow()
    {
        return this.id+";"+this.fullName+";"+this.department+";"+this.salary;
    }
}