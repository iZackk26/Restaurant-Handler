package Person;

public class Costumer extends Person{
    private String province;
    private String district;
    private String addressInformation;

    public Costumer(String name, String lastName, String gender, int age, int id, int cellphoneNumber,String province, String district, String addressInformation){
        super(name, lastName, gender, age, id, cellphoneNumber);
        this.province = province;
        this.district = district;
        this.addressInformation = addressInformation;
    }

    public Costumer(){
        super();
        this.province = "";
        this.district = "";
        this.addressInformation = "";
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddressInformation() {
        return addressInformation;
    }

    public void setAddressInformation(String addressInformation) {
        this.addressInformation = addressInformation;
    }
}
