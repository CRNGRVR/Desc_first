import java.util.List;
import java.util.Map;
public class CustomerRepository extends Repository<Customer>
{
    // Дополнительные методы:
    public CustomerRepository(Map<String, Customer> items, String repositoryName)
    {
        super(items, repositoryName);
    }

    public List<Customer> findCustomersByEmail(String email) { return null; }
    public List<Customer> findCustomersByName(String name) { return null; }
}