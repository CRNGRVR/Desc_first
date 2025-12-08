import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main
{
    public static void main(String[] args)
    {
        testProduct();
    }

    public Product mock(String s)
    {
        return new Product(s, 0, s, 0);
    }

    public static void testProduct()
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Food", 0, "Shaurma", 100));
        products.add(new Product("Jabloko", 1, "MacBook Pro 14", 101));
        products.add(new Product("Fenomen", 3, "gazel with eggs", 10000));
        products.add(new Product("Food", 4, "Sloika with Cheese", 50));

        CsvFileProcessor<Product> csvFileProcessor = new CsvFileProcessor<Product>();
        csvFileProcessor.saveToFile("./test/products.csv", products);

        csvFileProcessor.source = "./test/products.csv";
        List<Product> productsFromFile = new ArrayList<>();
        Function<String, Product> f = (str) -> {
            String[] strings = new String[4];
            strings = str.split(";", 0);

            String category = strings[3];
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            double price = Double.parseDouble(strings[2]);   
            return new Product(category, id, name, price);
        };

        try
        {
            productsFromFile = csvFileProcessor.readFromFile(f);

            List<Product> expensive = new ArrayList<>();
            for (Product product : productsFromFile) {
                if (product.price > 100)
                {
                    expensive.add(product);
                }
            }

            csvFileProcessor.saveToFile("./test/expensive_products.csv", expensive);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
