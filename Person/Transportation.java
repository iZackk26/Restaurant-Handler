package Person;

import java.io.Serializable;

public class Transportation implements Serializable {
    private String plateNumber;
    private String type;


    public Transportation(String plateNumber, String type){
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public Transportation(){
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
