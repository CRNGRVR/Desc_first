

public class Product implements CsvEntity {
    public int id;
    public String name;
    public double price;
    public String category;

    public Product(String category, int id, String name, double price) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toCsvRow()
    {
        return this.id+";"+this.name+";"+this.price+";"+this.category;
    }

}
