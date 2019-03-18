public class Size implements Chargable {
    String name;
    double radius;
    double price;

    public Size(String name, double radius, double price){
        this.name = name;
        this.radius = radius;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return this.getName() + " - " + this.getPrice();
    }
}
