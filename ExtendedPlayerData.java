import java.io.Serializable;

public class ExtendedPlayerData extends PlayerData implements Serializable {
    
    private String Mail;
    private boolean DSGVO;

    public ExtendedPlayerData(String nickName, int score, String mail, boolean dsgvo) {
        super(nickName, score);

        this.Mail = mail;
        this.DSGVO = dsgvo;
    }

    @Override
    public String serialize() {
        int zustimmung = this.DSGVO ? 1 : 0;
        return super.serialize() + "#@#" + this.Mail + "#@#" +zustimmung;
    }

    @Override
    public void deserialize(String values) {
        String[] data  = values.split("#@#",4);
        this.Mail = data[2];
        this.DSGVO = data[3] == "1";
        super.deserialize(data[0] + "#@#" + data[1]);
    }
}
