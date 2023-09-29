package Person;

public class DeliveryDriver extends Person{
    public Vehicle vehicle;

    public DeliveryDriver(String name, String gender, int age, int id, int cellphone, Vehicle vehicle){
        super(name, name, gender, age, id, cellphone);
        this.vehicle = vehicle;
    }

    public DeliveryDriver(){
        super();
        this.vehicle = null;
    }


    // Methods

    public void assignOrder(){
        System.out.println("Assigning order");
    }
}
