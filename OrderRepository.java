import java.util.List;

public class OrderRepository extends Repository<Order> {
 // Дополнительные методы:
 public List<Order> getOrdersByCustomer(String customerId)
 public List<Order> getOrdersByStatus(String status)
}
