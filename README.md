# Система управления интернет-магазином

Проект представляет собой систему управления интернет-магазином с функционалом для работы с товарами, клиентами и заказами.

## Структура проекта

```
src/
 ├── Product.java
 ├── Customer.java
 ├── Order.java
 ├── Repository.java
 ├── ProductRepository.java
 ├── CustomerRepository.java
 └── OrderRepository.java
```

## Функциональность

### Этап 1: Класс Product и Category

#### Класс Product
```java
public class Product {
    private String id;          // Уникальный идентификатор
    private String name;        // Название товара
    private String description; // Описание
    private double price;       // Цена
    private int quantity;       // Количество на складе
    private String category;    // Категория товара
    private double rating;      // Рейтинг (0-5)
}
```

**Методы класса Product:**
- Конструктор с параметрами (id, name, price, category)
- Геттеры и сеттеры с валидацией (цена и количество не могут быть отрицательными)
- `String toString()` - формат: "Название: [name], Цена: [price], Категория: [category]"
- `boolean equals()` и `int hashCode()` на основе id
- `boolean containsKeyword(String keyword)` - поиск в названии и описании
- `double getTotalValue()` - общая стоимость (цена × количество)
- `double applyDiscount(double percent)` - применение скидки

### Этап 2: Обобщенный класс Repository

#### Класс Repository<T>
```java
public class Repository<T> {
    protected Map<String, T> items; // Хранит элементы по ID
    protected String repositoryName;
}
```

**Методы класса Repository<T>:**
- `void addItem(String id, T item)` - добавление элемента
- `boolean removeItem(String id)` - удаление элемента
- `T getItem(String id)` - получение элемента
- `List<T> getAllItems()` - все элементы
- `int getItemsCount()` - количество элементов
- `boolean containsItem(String id)` - проверка наличия
- `List<T> searchItems(Predicate<T> condition)` - поиск по условию

#### Специализированные репозитории

**ProductRepository:**
```java
public class ProductRepository extends Repository<Product> {
    public List<Product> getProductsByCategory(Category category);
    public List<Product> getProductsInPriceRange(double minPrice, double maxPrice);
    public List<Product> getLowStockProducts(int threshold);
}
```

### Этап 3: Классы Customer и Order

#### Класс Customer
```java
public class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
```

**Методы класса Customer:**
- Конструктор, геттеры, сеттеры
- `toString()`, `equals()`, `hashCode()` на основе id
- `containsText(String text)` - поиск в имени и email

#### Класс Order
```java
public class Order {
    private String orderId;
    private String customerId;
    private String status; // PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
    private Map<String, Integer> items; // productId -> quantity
    private double totalAmount;
}
```

**Методы класса Order:**
- `void addItem(String productId, int quantity)`
- `boolean removeItem(String productId)`
- `double calculateTotal()` - сумма заказа
- `int getItemsCount()` - количество товаров в заказе

#### Специализированные репозитории

**OrderRepository:**
```java
public class OrderRepository extends Repository<Order> {
    public List<Order> getOrdersByCustomer(String customerId);
    public List<Order> getOrdersByStatus(String status);
}
```

**CustomerRepository:**
```java
public class CustomerRepository extends Repository<Customer> {
    public List<Customer> findCustomersByEmail(String email);
    public List<Customer> findCustomersByName(String name);
}
```

## Тестирование

После каждого этапа разработки необходимо тестировать работу методов соответствующих классов.

## Пример использования Predicate

```java
import java.util.function.Predicate;

class User {
    String name;
    int age;
    
    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class UserCheck {
    public static void main(String[] args) {
        Predicate<User> isAdult = user -> user.age >= 18;
        User user1 = new User("Anna", 25);
        User user2 = new User("Alex", 15);
        
        System.out.println(isAdult.test(user1)); // true
        System.out.println(isAdult.test(user2)); // false
    }
}
```
 public List<Customer> findCustomersByName(String name)
}
