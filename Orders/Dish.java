package Orders;

public class Dish {
    private String name;
    private String description;
    private String estimatedTime;
    private int price;
    private boolean finished;


    // Methods

    public Dish(String name, String description, String estimatedTime, int price, boolean finished) {
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.price = price;
        this.finished = finished;
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

    public void setName() {
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

    public void ToString() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Estimated time: " + estimatedTime);
        System.out.println("Price: " + price);
        if (finished) {
            System.out.println("Status: in progress");
        } else {
            System.out.println("Status: completed");
        }
    }
}