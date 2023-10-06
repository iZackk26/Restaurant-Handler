package Orders;

import java.io.Serializable;

public class Dish implements Serializable {
    private String name;
    private String description;
    private String estimatedTime;
    private int price;
    private boolean finished;
    private int timesOrdered;

    // Methods

    public Dish(String name, String description, String estimatedTime, int price, boolean finished) {
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.price = price;
        this.finished = finished;
        this.timesOrdered = 0;
    }

    public Dish() {
        this.name = "";
        this.description = "";
        this.estimatedTime = "";
        this.price = 0;
        this.finished = false;
    }

    public void MarkAsFinished() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getTimesOrdered() {
        return timesOrdered;
    }

    public void setTimesOrdered(int timesOrdered) {
        this.timesOrdered = timesOrdered;
    }

    public String toString() {
        String string = "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Estimated time: " + estimatedTime + "\n" +
                "Price: " + price + "\n" +
                "Finished: " + (finished ? "Yes" : "No");

        return string;
    }
}