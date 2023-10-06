package Person;

import java.io.Serializable;

/**
 * The type Costumer.
 */
public class Costumer extends Person implements Serializable {
    /**
     * The province where the delivery address is located.
     */
    private String province;

    /**
     * The district within the province where the delivery address is located.
     */
    private String district;

    /**
     * Detailed information about the delivery address.
     */
    private String addressInformation;

    /**
     * The password associated with the user's account.
     */
    private String password;

    /**
     * Instantiates a new Costumer.
     *
     * @param name               the name
     * @param lastName           the last name
     * @param gender             the gender
     * @param age                the age
     * @param id                 the id
     * @param cellphoneNumber    the cellphone number
     * @param province           the province
     * @param district           the district
     * @param addressInformation the address information
     * @param password           the password
     */
    public Costumer(String name, String lastName, String gender, int age, int id, int cellphoneNumber,String province, String district, String addressInformation, String password){
        super(name, lastName, gender, age, id, cellphoneNumber);
        this.province = province;
        this.district = district;
        this.addressInformation = addressInformation;
        this.password = password;
    }

    /**
     * Instantiates a new Costumer.
     */
    public Costumer(){
        super();
        this.province = "";
        this.district = "";
        this.addressInformation = "";
        this.password = "";
    }

    /**
     * Gets province.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets province.
     *
     * @param province the province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets district.
     *
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets district.
     *
     * @param district the district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Gets address information.
     *
     * @return the address information
     */
    public String getAddressInformation() {
        return addressInformation;
    }

    /**
     * Sets address information.
     *
     * @param addressInformation the address information
     */
    public void setAddressInformation(String addressInformation) {
        this.addressInformation = addressInformation;
    }

    /**
     * Set password.
     *
     * @param password the password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Get password string.
     *
     * @return the string
     */
    public String getPassword(){
        return password;
    }
}
