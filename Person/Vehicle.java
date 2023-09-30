package Person;

public class Vehicle {
    private String plateNumber;
    private String type;


    public Vehicle(String plateNumber, String type){
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public Vehicle(){
        this.plateNumber = "";
        this.type = "";
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
