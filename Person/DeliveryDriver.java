package Person;

import java.io.Serializable;

/**
 * The type Delivery driver.
 */
public class DeliveryDriver extends Person implements Serializable {
    /**
     * The type of transportation used by the delivery driver (e.g., car, bicycle).
     */
    private Transportation car;

    /**
     * The password associated with the delivery driver's account.
     */
    private String password;

    /**
     * The total number of deliveries completed by the delivery driver.
     */
    private int totalDeliveries = 0;

    /**
     * Instantiates a new Delivery driver.
     *
     * @param name      the name
     * @param lastName  the last name
     * @param gender    the gender
     * @param age       the age
     * @param id        the id
     * @param cellphone the cellphone
     * @param password  the password
     * @param vehicle   the vehicle
     */
    public DeliveryDriver(String name, String lastName, String gender, int age, int id, int cellphone,String password, Transportation vehicle){
        super(name, lastName, gender, age, id, cellphone);
        this.car = vehicle;
        this.password = password;
    }

    /**
     * Instantiates a new Delivery driver.
     */
    //public DeliveryDriver(){
        //super();
    //}


    /**
     * Gets car.
     *
     * @return the car
     */
// Methods
    public Transportation getCar() {
        return car;
    }

    /**
     * Sets car.
     *
     * @param car the car
     */
    public void setCar(Transportation car) {
        this.car = car;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets total deliveries.
     *
     * @param totalDeliveries the total deliveries
     * @return the total deliveries
     */
    public int setTotalDeliveries(int totalDeliveries) {
        return this.totalDeliveries = totalDeliveries;
    }

    /**
     * Gets total deliveries.
     *
     * @return the total deliveries
     */
    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    /**
     * Add total deliveries int.
     *
     * @return the int
     */
    public int addTotalDeliveries() {
        return this.totalDeliveries++;
    }

}
