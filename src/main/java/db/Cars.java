package db;

public class Cars {
    private String name;
    private int model;
    private int price;
    private int seats;
    private String issues;

    public Cars(String name, int model, int price, int seats, String issues) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.seats = seats;
        this.issues = issues;
    }

    public String getName() {
        return name;
    }

    public int getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getSeats() {
        return seats;
    }

    public String getIssues() {
        return issues;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "name='" + name + '\'' +
                ", model=" + model +
                ", price=" + price +
                ", seats=" + seats +
                ", issues='" + issues + '\'' +
                '}';
    }
}
