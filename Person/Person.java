package Person;

/**
 * The type Person.
 */
public abstract class Person {
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Last name.
     */
    protected String lastName;
    /**
     * The Gender.
     */
    protected String gender;
    /**
     * The Age.
     */
    protected int age;
    /**
     * The Id.
     */
    protected int id;
    /**
     * The Cellphone number.
     */
    protected int cellphoneNumber;

    /**
     * Instantiates a new Person.
     *
     * @param name            the name
     * @param lastName        the last name
     * @param gender          the gender
     * @param age             the age
     * @param id              the id
     * @param cellphoneNumber the cellphone number
     */
    public Person(String name, String lastName,String gender, int age, int id, int cellphoneNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
        this.cellphoneNumber = cellphoneNumber;
    }

    /**
     * Instantiates a new Person.
     */
    public Person(){
        this.name = "";
        this.gender = "";
        this.age = 0;
        this.id = 0;
        this.cellphoneNumber = 0;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets cellphone number.
     *
     * @return the cellphone number
     */
    public int getCellphoneNumber() {
        return cellphoneNumber;
    }

    /**
     * Sets cellphone number.
     *
     * @param cellphoneNumber the cellphone number
     */
    public void setCellphoneNumber(int cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

}
