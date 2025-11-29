
import java.util.Objects;



public class Product
{
    private String id; // Уникальный идентификатор
    private String name; // Название товара
    private String description; // Описание
    private double price; // Цена
    private int quantity; // Количество на складе
    private String category; // Категория товара
    private double rating; // Рейтинг (0-5)

    public Product (String id, String name, double price, String category)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
        this.description="";
        this.quantity=0;
        this.rating=0;
    }

    public double getTotalValue()
    {
        return this.price*this.quantity;
    }

    public boolean constainsKeyword (String keyword)
    {
        return  name.contains(keyword) || description.contains(keyword);
    }

    public double applyDiscount(double percent)
    {
        return this.price-this.price*percent;
    }

    @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Product{");
            sb.append("id=").append(id);
            sb.append(", name=").append(name);
            sb.append(", description=").append(description);
            sb.append(", price=").append(price);
            sb.append(", quantity=").append(quantity);
            sb.append(", category=").append(category);
            sb.append(", rating=").append(rating);
            sb.append('}');
            return sb.toString();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (this.price<0)
        {
            System.out.println("Error valid: price<0");
        }
        else
        {
            this.price = price;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 89 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.id, other.id);
    }
}