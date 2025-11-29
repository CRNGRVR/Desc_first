import java.util.List;
import java.util.Map;

public class OrderRepository extends Repository<Order>
{
    // Дополнительные методы:
    public OrderRepository(Map<String, Order> items, String repositoryName)
    {
        super(items, repositoryName);
        //TODO Auto-generated constructor stub
    }

    public List<Order> getOrdersByCustomer(String customerId) {return null;}
    public List<Order> getOrdersByStatus(String status) {return null;}
}
