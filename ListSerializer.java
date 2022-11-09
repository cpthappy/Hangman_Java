
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSerializer<T> {

    public void serialize(List<T> list, String path) {

    }

    public List<T> deserialize(String path) throws IOException {

    List<T> result = new ArrayList<T>();
    File initialFile = new File(path);
    InputStream inputStream = new FileInputStream(initialFile);
    
    try (BufferedReader br
      = new BufferedReader(new InputStreamReader(inputStream))) {
        String line;
        while ((line = br.readLine()) != null) {
        
            player.deserialize(line);
        }
    }
    
    return resultStringBuilder.toString();
    }

}