import java.util.ArrayList;

public class PizzaPlace {
    String name;
    String phone;
    ArrayList<Crust> crusts;
    ArrayList<Size> sizes;
    ArrayList<Ingredient> ingredients;
    ArrayList<Order> orders;


    // static variable single_instance of type Singleton
    private static PizzaPlace single_instance = null;


    // static method to create instance of Singleton class
    public static PizzaPlace getInstance() {
        if (single_instance == null)
            single_instance = new PizzaPlace();

        return single_instance;
    }



    private PizzaPlace( ){
        this.name = "IT2045C Pizza Place";
        this.phone = "111-222-3333";;
        this.orders = new ArrayList<Order>();
        //Sizes
        this.sizes = new ArrayList<Size>();
        this.sizes.add(new Size("Small",6,8));
        this.sizes.add(new Size("Medium",10,12));
        this.sizes.add(new Size("Large",12,16));
        this.sizes.add(new Size("Super",16,20));
        //Crusts
        this.crusts = new ArrayList<Crust>();
        this.crusts.add(new Crust("Thin",0));
        this.crusts.add(new Crust("Regular",0));
        this.crusts.add(new Crust("Deep-dish",0));
        //Ingredients
        this.ingredients = new ArrayList<Ingredient>();
        this.ingredients.add(new Ingredient("Cheese",1));
        this.ingredients.add(new Ingredient("Mushrooms",1));
        this.ingredients.add(new Ingredient("Chicken",1));
        this.ingredients.add(new Ingredient("Pepperoni",1));
        this.ingredients.add(new Ingredient("Tuna",1));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void placeOrders(Order order) {
        this.orders.add(order);
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Crust> getCrusts() {
        return crusts;
    }

    public void setCrusts(ArrayList<Crust> crusts) {
        this.crusts = crusts;
    }

    public ArrayList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<Size> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
