import java.util.*;

public class Order {
 private String orderId;
 private String customerId;
 private String status;
 private Map<String, Integer> items;
 private double totalAmount;

    public Order(String customerId, Map items, String orderId, String status, double totalAmount) {
        this.customerId = customerId;
        this.items = items;
        this.orderId = orderId;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() 
    {
        return orderId;
    }

    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getCustomerId() 
    {
        return customerId;
    }

    public void setCustomerId(String customerId) 
    {
        this.customerId = customerId;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public Map getItems() 
    {
        return items;
    }

    public void setItems(Map items) 
    {
        this.items = items;
    }

    public double getTotalAmount() 
    {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) 
    {
        this.totalAmount = totalAmount;
    }
    public void addItem(String productId, int quantity)
    {
        items.put(productId, quantity);
    }
    public boolean removeItem(String productId)
    {
        return items.containsKey(productId);

    }
    public double calculateTotal()
    {
        this.totalAmount = items.values().stream()
        .mapToDouble(qty -> qty * 10.0).sum(); //предположим цену в 10 хзхз
        return this.totalAmount;
    }
    public int getItemsCount()
    {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }
}
