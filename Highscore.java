import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Highscore {
    private List<PlayerData> scoreList;
    private String storagePath;
    private ListSerializer<PlayerData> serializer;

    /**
     * 
     */
    public Highscore(String path) {
        this.serializer = new ListSerializer<>(PlayerData::new);
        this.scoreList = new ArrayList<PlayerData>();
        this.storagePath = path;
        this.readFromFile();
    }

    public int addNewEntry(PlayerData data) {
        this.scoreList.add(data);
        Collections.sort(this.scoreList);

        return this.scoreList.indexOf(data) + 1;
    }

    public String[] getHighScore(int max) {
        String[] result = new String[max];

        for(int i=0; i<Math.min(this.scoreList.size(), max); i++) {
            result[i] = "Platz " + (i+1) +": " + this.scoreList.get(i).toString();
        }

        return result;
    }

    private void readFromFile() {
        
        try {
            this.scoreList = this.serializer.deserialize(this.storagePath);
        } catch (IOException e){
            this.scoreList = new ArrayList<PlayerData>();
        }
    }

    public void save() {
        try {
            this.serializer.serialize(this.scoreList, this.storagePath);
        } catch (IOException e){
            System.err.println("Highscore-Liste konnte nicht gespeichert werden");
        }

    }
}
