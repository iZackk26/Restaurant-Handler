package Person;

import java.io.Serializable;

/**
 * The type Employee.
 */
public class Employee extends Person implements Serializable {
    /**
     * The unique identifier for the employee.
     */
    private int employeeId;

    /**
     * The password associated with the employee's account.
     */
    private String password;

    /**
     * Instantiates a new Employee.
     *
     * @param name            the name
     * @param lastName        the last name
     * @param gender          the gender
     * @param age             the age
     * @param id              the id
     * @param cellphoneNumber the cellphone number
     * @param employeeId      the employee id
     * @param password        the password
     */
    public Employee(String name, String lastName, String gender, int age, int id, int cellphoneNumber, int employeeId, String password) {
        super(name, lastName, gender, age, id, cellphoneNumber);
        this.employeeId = employeeId;
        this.password = password;
    }

    /**
     * Instantiates a new Employee.
     */
    public Employee() {
        super();
        this.employeeId = 0;
    }

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets employee id.
     *
     * @param employeeId the employee id
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Get password string.
     *
     * @return the string
     */
    public String getPassword(){
        return password;
    }

    /**
     * Set password.
     *
     * @param password the password
     */
    public void setPassword(String password){
        this.password = password;
    }
}


