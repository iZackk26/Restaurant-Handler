package Person;

import java.io.Serializable;

public class DeliveryDriver extends Person implements Serializable {
    private Transportation car;
    private String password;
    private int totalDeliveries = 0;



    public DeliveryDriver(String name, String lastName, String gender, int age, int id, int cellphone,String password, Transportation vehicle){
        super(name, lastName, gender, age, id, cellphone);
        this.car = vehicle;
        this.password = password;
    }

    public DeliveryDriver(){
        super();
    }


    // Methods
    public Transportation getCar() {
        return car;
    }
    public void setCar(Transportation car) {
        this.car = car;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public int setTotalDeliveries(int totalDeliveries) {
        return this.totalDeliveries = totalDeliveries;
    }
    public int getTotalDeliveries() {
        return totalDeliveries;
    }
    public int addTotalDeliveries() {
        return this.totalDeliveries++;
    }


}
