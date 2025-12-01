import java.util.*;
import java.util.function.Predicate;

public class ProductRepository extends Repository<Product>
{
    public ProductRepository(Map<String, Product> items, String repositoryName)
    {
        super(items, repositoryName);
        //TODO Auto-generated constructor stub
    }

    //  TODO:   Неплохо бы намутить предикатов
    public List<Product> getProductByCategory(String category)
    {
        List<Product> passed = new ArrayList<>();
        for (String keyString : items.keySet())
        {
            if (items.get(keyString).getCategory() == category)
            {
                passed.add(items.get(keyString));
            }
        }

        return passed;
    }

    //  TODO:   Неплохо бы намутить предикатов
    public List<Product> getProductInPriceRange(double minPrice, double maxPrice)
    {
        List<Product> passed = new ArrayList<>();
        for (String keyString : items.keySet())
        {
            Product testable = items.get(keyString);
            if (testable.getPrice() >= minPrice && testable.getPrice() <= maxPrice)
            {
                passed.add(items.get(keyString));
            }
        }

        return passed;
    }

    //  TODO:   Неплохо бы намутить предикатов
    public List<Product> getLowStockProducts(int threshold)
    {
        List<Product> passed = new ArrayList<>();
        for (String keyString : items.keySet())
        {
            Product testable = items.get(keyString);
            if (testable.getQuantity() < threshold)
            {
                passed.add(items.get(keyString));
            }
        }

        return passed;
    }
}
