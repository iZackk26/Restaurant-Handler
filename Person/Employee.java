package Person;

public class Employee {
    private int employeeId;
    private String boss;
    private int salary;

    //Methods

    public Employee(int employeeId, String boss, int salary) {
        this.employeeId = employeeId;
        this.boss = boss;
        this.salary = salary;
    }

    public Employee() {
        this.employeeId = 0;
        this.boss = "";
        this.salary = 0;
    }

    public void takeOrder(){
        System.out.println("Taking order");
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
