package Person;

public class DeliveryDriver extends Person{
    protected Transportation car;

    public DeliveryDriver(String name, String lastName, String gender, int age, int id, int cellphone, Transportation vehicle){
        super(name, lastName, gender, age, id, cellphone);
        this.car = vehicle;
    }

    public DeliveryDriver(){
        super();
    }


    // Methods
    public Transportation getCar() {
        return car;
    }

}
