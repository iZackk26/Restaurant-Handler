package Person;

public class DeliveryDriver extends Person{
    public Vehicle vehicle;

    public DeliveryDriver(String name, String lastName, String gender, int age, int id, int cellphone, Vehicle vehicle){
        super(name, lastName, gender, age, id, cellphone);
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
