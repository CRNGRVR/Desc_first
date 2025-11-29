import java.util.*;
import java.util.function.Predicate;

public class Repository<T>
{
    protected Map<String, T> items; // Хранит элементы по ID
    protected String repositoryName;

    public Repository()
    {
        items = new HashMap<>();
    }

    public Map<String, T> getItems()
    {
        return items;
    }

    public void setItems(Map<String, T> items)
    {
        this.items = items;
    }

    public String getRepositoryName()
    {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName)
    {
        this.repositoryName = repositoryName;
    }
    
    public void addItem(String id, T item)
    {
        items.put(id, item);
    }

    public boolean reomveItem(String id)
    {
        if (items.containsKey(id))
        {
            items.remove(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    public T getItem(String id)
    {
        return items.get(id);
    }

    public List<T> getAllItems()
    {
        List<T> all = new ArrayList<>();
        
        for (String keyString : items.keySet())
        {
            all.add(items.get(keyString));    
        }

        return all;
    }

    public int getItemsCount()
    {
        return items.size();
    }

    public boolean containsItem(String id)
    {
        return items.containsKey(id);
    }

    public List<T> searchItems(Predicate<T> condition)
    {
        List<T> passed = new ArrayList<>();
        for (String keyString : items.keySet())
        {
            condition.test(items.get(keyString));
            passed.add(items.get(keyString));
        }

        return passed;
    }    
}
