package Person;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private int employeeId;
    private String password;

    //Methods

    public Employee(String name, String lastName, String gender, int age, int id, int cellphoneNumber, int employeeId, String password) {
        super(name, lastName, gender, age, id, cellphoneNumber);
        this.employeeId = employeeId;
        this.password = password;
    }

    public Employee() {
        super();
        this.employeeId = 0;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}


