import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Highscore {
    private List<PlayerData> scoreList;

    /**
     * 
     */
    public Highscore() {
        this.scoreList = new ArrayList<PlayerData>();
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
}
