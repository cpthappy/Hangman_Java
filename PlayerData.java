public class PlayerData implements Comparable<PlayerData>, Serializable<PlayerData>{
    private String nickName;
    private int score;

    public PlayerData(String name, int score) {
        this.nickName = name;
        this.score = score;
    }

    public PlayerData() { 
        this.nickName = "";
        this.score = 0;
    }

    @Override
    public int compareTo(PlayerData o) {
        return Integer.compare(this.score, o.score);
    }

    public String getNickName() {
        return nickName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return this.nickName + "(" + this.score +")";
    }

    @Override
    public String serialize(PlayerData object) {
        return this.nickName + "@#@" + this.score;
    }

    @Override
    public void deserialize(String str) {
        String[] data  = str.split("#@#",2);
        this.nickName = data[0];
        this.score =  Integer.parseInt(data[1]);
    }
    
}
