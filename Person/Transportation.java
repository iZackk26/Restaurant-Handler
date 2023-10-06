package Person;

import java.io.Serializable;

/**
 * The type Transportation.
 */
public class Transportation implements Serializable {
    /**
     * The plate number of the vehicle.
     */
    private String plateNumber;

    /**
     * The type or category of the vehicle (e.g., car, truck, motorcycle).
     */
    private String type;

    /**
     * Instantiates a new Transportation.
     *
     * @param plateNumber the plate number
     * @param type        the type
     */
    public Transportation(String plateNumber, String type){
        this.plateNumber = plateNumber;
        this.type = type;
    }

    /**
     * Instantiates a new Transportation.
     */
    public Transportation(){
        this.plateNumber = "";
        this.type = "";
    }

    /**
     * Gets plate number.
     *
     * @return the plate number
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Sets plate number.
     *
     * @param plateNumber the plate number
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }
}
