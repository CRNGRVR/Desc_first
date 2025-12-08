import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main
{
    public static void main(String[] args)
    {
        testProduct();
        testEmployee();
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

    public static void testEmployee()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("IT", "Indys Indesovich", 1, 0));
        employees.add(new Employee("AI(is not it because its Oleg)", "Oleg", 2, 1));
        employees.add(new Employee("Sales", "Sanya", 3, 1000));
        employees.add(new Employee("IT", "a ndrey", 4, 100000));

        CsvFileProcessor<Employee> csvFileProcessor = new CsvFileProcessor<Employee>();
        csvFileProcessor.saveToFile("./test/employees.csv", employees);

        csvFileProcessor.source = "./test/employees.csv";
        List<Employee> employeesFromFile = new ArrayList<>();
        Function<String, Employee> f = (str) -> {
            String[] strings = new String[4];
            strings = str.split(";", 0);

            String department = strings[2];
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            double salary = Double.parseDouble(strings[3]);   
            return new Employee(department, name, id, salary);
        };

        try
        {
            employeesFromFile = csvFileProcessor.readFromFile(f);

            List<Employee> it = new ArrayList<>();
            for (Employee empl : employeesFromFile) {
                if (empl.department.equals("IT"))
                {
                    it.add(empl);
                }
            }

            csvFileProcessor.saveToFile("./test/employees_IT.csv", it);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
