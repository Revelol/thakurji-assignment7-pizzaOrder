import java.util.ArrayList;

public class Pizza {
    Crust crust;
    Size size;
    ArrayList<Ingredient> ingredients;

    public Pizza(Crust crust, Size size, ArrayList<Ingredient> ingredients){
        this.crust = crust;
        this.size = size;
        this.ingredients = ingredients;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredients(Ingredient ingredients) {
        this.ingredients.add(ingredients);
    }

    public double getTotal(){
        double total = 0;
        total +=size.getPrice();
        total += crust.getPrice();
        for(Ingredient x: ingredients){
            total += x.getPrice();
        }
        return total;
    }
}
