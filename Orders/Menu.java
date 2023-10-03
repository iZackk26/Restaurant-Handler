package Orders;
import java.util.ArrayList;
public class Menu {
    private ArrayList<Dish> Catalog;


    public Menu() {
        Catalog = new ArrayList<Dish>();
    }

    // Methods
    public void AddDish(Dish dish) {
        Catalog.add(dish);


    }
    public void RemoveDish() {
    }

    public ArrayList<Dish> getCatalog() {
        return Catalog;
    }

    public void setCatalog(ArrayList<Dish> catalog) {
        Catalog = catalog;
    }
    public void printMenu(){
        for (int i = 0; i < Catalog.size(); i++) {
            // Print the entire menu with it
            Dish temp = Catalog.get(i);
        }
    }
}
