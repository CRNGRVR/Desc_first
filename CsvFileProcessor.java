import java.io.*;
import java.util.*;
import java.util.function.Function;

public class CsvFileProcessor <T extends CsvEntity> {
    public String source;

    public List<T> readFromFile (Function<String, T> mapper) throws IOException
    {
        File file =new File(source);
        List<String> lines= new ArrayList<>();
        List<T> result = new ArrayList<>();
        try(BufferedReader br =new BufferedReader(new FileReader(file));)
        {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        for (String line : lines) {
            T item =mapper.apply(line);
            result.add(item);
        }
        return result;
    }

    public void saveToFile (String destination, List<T> data)
    {
        try
        {
            BufferedWriter bw =new BufferedWriter(new FileWriter(destination));
            for (T t : data) {
                bw.write(t.toCsvRow());
                bw.write("\n");
            }
            bw.close();
            System.out.println("Save data in "+destination);   
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
