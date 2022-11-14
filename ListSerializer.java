
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ListSerializer<T extends Serializable> {

    private Supplier<T> supplier;
    
    ListSerializer(Supplier<T> supplier) {
        this.supplier = supplier;
    }
     
    public void serialize(List<T> list, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (T entry : list) {
            writer.write(entry.serialize());
            writer.write("\n");
        }
        
        writer.close();
    }

    public List<T> deserialize(String path) throws IOException {

        List<T> result = new ArrayList<T>();
        File initialFile = new File(path);
        InputStream inputStream = new FileInputStream(initialFile);
        
        try (BufferedReader br
        = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                T element = supplier.get();
                element.deserialize(line);
                result.add(element);
            }
        }
        
        return result;
    }

}