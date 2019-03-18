import java.util.ArrayList;

public class Order {
    ArrayList<Pizza> pizzas;
    double TAX_RATE = .07;

    public Order(){
        this.pizzas = new ArrayList<Pizza>();
    }

    public void addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public String getReciept(){
        return "";
    }

    public double getTotal(){
        double total = 0;
        for(Pizza x: pizzas){
            total += x.getTotal();
        }
        return total;
    }

    public String getReceipt(){
        String receiptString = "Pizza\n=======================================\n";
        for(int pizzaCounter = 0; pizzaCounter < pizzas.size(); pizzaCounter++){
            receiptString += "--------- Pizza: " + pizzaCounter+1 + " : " + pizzas.get(pizzaCounter).getTotal() + " ----------------------------\n";
            receiptString += String.format("%-10s & %-10s\t\t$%5.2f\n",
                    pizzas.get(pizzaCounter).getCrust().getName(),
                    pizzas.get(pizzaCounter).getSize().getName(),
                    pizzas.get(pizzaCounter).getSize().getPrice()
            );
            for(Ingredient ingredient: this.pizzas.get(pizzaCounter).getIngredients()){
                receiptString += String.format("     %-20s\t\t$%5.2f\n", ingredient.getName(), ingredient.getPrice());
            }

        }

        receiptString += "\n\n";
        receiptString += String.format("Subtotal\t\t\t$%5.2f\n", this.getTotal());
        receiptString += String.format("Tax\t\t\t$%5.2f\n", this.getTotal() * TAX_RATE);
        receiptString += "------------------------------------------------\n";
        receiptString += String.format("Total\t\t\t$%5.2f\n", this.getTotal() * (1 + TAX_RATE));


        return receiptString;
    }
}
