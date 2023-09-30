package Person;

public abstract class Person {
    private String name;
    private String lastName;
    private String gender;
    private int age;
    private int id;
    private int cellphoneNumber;

    public Person(String s, String name, String gender, int age, int id, int cellphoneNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
        this.cellphoneNumber = cellphoneNumber;
    }

    public Person(){
        this.name = "";
        this.gender = "";
        this.age = 0;
        this.id = 0;
        this.cellphoneNumber = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(int cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

}
