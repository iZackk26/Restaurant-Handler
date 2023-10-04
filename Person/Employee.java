package Person;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private int employeeId;
    private String boss;
    private int salary;

    //Methods

    public Employee(String name, String lastName, String gender, int age, int id, int cellphoneNumber, int employeeId, String boss, int salary) {
        super(name, lastName,  gender, age, id, cellphoneNumber);
        this.employeeId = employeeId;
        this.boss = boss;
        this.salary = salary;
    }

    public Employee() {
        super();
        this.employeeId = 0;
        this.boss = "";
        this.salary = 0;
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
