package Orders;

import java.io.Serializable;

/**
 * The type Dish.
 */
public class Dish implements Serializable {
    /**
     * The name of the dish.
     */
    private String name;

    /**
     * A description of the dish.
     */
    private String description;

    /**
     * The estimated time required to prepare the dish.
     */
    private String estimatedTime;

    /**
     * The price of the dish.
     */
    private int price;

    /**
     * A flag indicating whether the dish is finished (e.g., cooked or prepared).
     */
    private boolean finished;

    /**
     * The number of times this dish has been ordered.
     */
    private int timesOrdered;

    /**
     * Instantiates a new Dish.
     *
     * @param name          the name
     * @param description   the description
     * @param estimatedTime the estimated time
     * @param price         the price
     * @param finished      the finished
     */
    public Dish(String name, String description, String estimatedTime, int price, boolean finished) {
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.price = price;
        this.finished = finished;
        this.timesOrdered = 0;
    }

    /**
     * Instantiates a new Dish.
     */
    public Dish() {
        this.name = "";
        this.description = "";
        this.estimatedTime = "";
        this.price = 0;
        this.finished = false;
    }

    /**
     * Mark as finished.
     */
    public void MarkAsFinished() {
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets estimated time.
     *
     * @return the estimated time
     */
    public String getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * Sets estimated time.
     *
     * @param estimatedTime the estimated time
     */
    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Is finished boolean.
     *
     * @return the boolean
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Sets finished.
     *
     * @param finished the finished
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * Gets times ordered.
     *
     * @return the times ordered
     */
    public int getTimesOrdered() {
        return timesOrdered;
    }

    /**
     * Sets times ordered.
     *
     * @param timesOrdered the times ordered
     */
    public void setTimesOrdered(int timesOrdered) {
        this.timesOrdered = timesOrdered;
    }

    /**
     * Returns a string representation of the Dish object.
     *
     * This method constructs and returns a string that includes the name, description,
     * price, and whether the dish is marked as finished.
     *
     * @return A string containing the name, description, price, and finished status of the dish.
     */
    public String toString() {
        String string = "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Price: " + price + "\n" +
                "Finished: " + (finished ? "Yes" : "No");

        return string;
    }
}