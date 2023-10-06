package Orders;
import java.util.ArrayList;

/**
 * The type Menu.
 */
public class Menu {
    /**
     * A list of dishes representing the catalog of available dishes.
     */
    private ArrayList<Dish> Catalog;

    /**
     * Instantiates a new Menu.
     */
    public Menu() {
        Catalog = new ArrayList<Dish>();
    }

    /**
     * Add dish.
     *
     * @param dish the dish
     */
    public void AddDish(Dish dish) {
        Catalog.add(dish);
    }

    /**
     * Remove dish.
     *
     * @param dish the dish
     */
    public void RemoveDish(Dish dish) {
        Catalog.remove(dish);
    }

    /**
     * Gets catalog.
     *
     * @return the catalog
     */
    public ArrayList<Dish> getCatalog() {
        return Catalog;
    }

    /**
     * Sets catalog.
     *
     * @param catalog the catalog
     */
    public void setCatalog(ArrayList<Dish> catalog) {
        Catalog = catalog;
    }

    /**
     * Print menu.
     */
    public void printMenu(){
        for (int i = 0; i < Catalog.size(); i++) {
            // Print the entire menu with it
            Dish temp = Catalog.get(i);
        }
    }

    /**
     * Search dish dish.
     *
     * @param name the name
     * @return the dish
     */
    public Dish searchDish(String name) {
        for (int i = 0; i < Catalog.size(); i++) {
            // Print the entire menu with it
            Dish temp = Catalog.get(i);
            if (temp.getName().equals(name)) {
                return temp;
            }
        }
        return null;
    }
}
