public class Program {
    public static void main(String[] args){
        //Use PizzaPlace Singleton
        PizzaPlace pizzaPlace = PizzaPlace.getInstance();
        PizzaGUI pizzaGUI = new PizzaGUI(pizzaPlace.getName(), pizzaPlace.getCrusts(), pizzaPlace.getSizes(), pizzaPlace. getIngredients());

    }
}
