import java.util.*;

public class Main
{
    //LET's GO!!!
    // Тесты для CustomerRepository
    private static void testCustomerRepository() {
        Map<String,Customer> mapCustomer =new HashMap<>();
        CustomerRepository repoCustomer = new CustomerRepository(mapCustomer,"CustomersRepos");
        Customer customer1 = new Customer("1", "Мстислав", "emailNETVOEDELO@peace.com", "850055555", "ул. Шрёнгера, 9.3/4");
        Customer customer2 = new Customer("2", "Чмо Ня", "UwU@only.fans", "82476969", "ул. Мируня, 5");
        Customer customer3 = new Customer("3", "Ростислав Тартышный", "rost********@mail.ru", "8923*******", "ул. Боль*********, ***/*");
        repoCustomer.addItem("1", customer1);
        repoCustomer.addItem("2", customer2);
        repoCustomer.addItem("3", customer3);
        //Detector by name
        System.out.println("Тест 1.1: Поиск Мстислава, ВЕРНИСЬ В КОНОХУ");
        List<Customer> resultByName = repoCustomer.findCustomersByName("Мстислав");
        resultByName.forEach(System.out::println);
        System.out.println("Ожидаемый результат: 1 клиента (Мстислав)");//А будет ни хрена, методе ничего нет:D
        System.out.println("Тест 1.2: Поиск славы, ВЕРНИСЬ В КОНОХУ");
        resultByName = repoCustomer.findCustomersByName("слав");
        resultByName.forEach(System.out::println);
        System.out.println("Ожидаемый результат: 0 клиента");
        System.out.println("\nТест 2: Поиск клиентов по email'emailNETVOEDELO@peace.com'");
        List<Customer> resultByEmail = repoCustomer.findCustomersByEmail("emailNETVOEDELO@peace.com");
        resultByEmail.forEach(System.out::println);
        System.out.println("Ожидаемый результат: 1 клиент (Иван Иванов)");
    }
    private static void testOrderRepository() {
        Map<String, Order> mapOrder = new HashMap<>();
        OrderRepository repoOrder = new OrderRepository(mapOrder,"OrdersRepos");
        Map<String, Integer> items1 = new HashMap<>();
        //О-оригинальность!
        items1.put("product1", 2);
        items1.put("product2", 1);
        Map<String, Integer> items2 = new HashMap<>();
        items2.put("product3", 3);
        Map<String, Integer> items3 = new HashMap<>();
        items3.put("product4", 1);
        // Найди 100 отличий
        Order order1 = new Order("1", items1, "order1", "PENDING", 0);
        Order order2 = new Order("2", items2, "order2", "SHIPPED", 0);
        Order order3 = new Order("1", items3, "order3", "PENDING", 0);

        repoOrder.addItem("order1", order1);
        repoOrder.addItem("order2", order2);
        repoOrder.addItem("order3", order3);
        System.out.println("Тест 1: Поиск заказов со статусом 'PENDING'");
        List<Order> pendingOrders = repoOrder.getOrdersByStatus("PENDING");
        pendingOrders.forEach(order -> System.out.println("Заказ: " + order.getOrderId()));
        System.out.println("Ожидаемый результат: 2 заказа (order1 и order3)");// Again?

        // Тест 2: Поиск заказов клиента "customer1"
        System.out.println("\nТест 2: Поиск заказов клиента 'customer1'");
        List<Order> customerOrders = repoOrder.getOrdersByCustomer("customer1");
        customerOrders.forEach(order -> System.out.println("Заказ: " + order.getOrderId()));
        System.out.println("Ожидаемый результат: 2 заказа (order1 и order3)");
    }

}
