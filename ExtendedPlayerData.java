import java.io.Serializable;

public class ExtendedPlayerData extends PlayerData implements Serializable {
    
    private String Mail;
    private boolean DSGVO;

    public ExtendedPlayerData(String nickName, int score, String mail, boolean dsgvo) {
        super(nickName, score);

        this.Mail = mail;
        this.DSGVO = dsgvo;
    }


}
