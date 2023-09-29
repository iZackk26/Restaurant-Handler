package Orders;

public class Menu {
    private Dish[] Catalog;

    public Menu(Dish[] catalog) {
        Catalog = catalog;
    }

    public Menu() {
        Catalog = null;
    }

    // Methods
    public void AddDish() {
    }
    public void RemoveDish() {
    }

    public Dish[] getCatalog() {
        return Catalog;
    }

    public void setCatalog(Dish[] catalog) {
        Catalog = catalog;
    }
}
