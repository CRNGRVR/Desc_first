import java.util.List;
public class CustomerRepository extends Repository<Customer>
{
 // Дополнительные методы:
 public List<Customer> findCustomersByEmail(String email)
 public List<Customer> findCustomersByName(String name)
}