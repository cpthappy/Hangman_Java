
public class ExtendedPlayerData extends PlayerData {
    
    private String Mail;
    public String getMail() {
        return Mail;
    }

    private boolean DSGVO;

    public boolean getDSGVO() {
        return DSGVO;
    }

    public ExtendedPlayerData(String nickName, int score, String mail, boolean dsgvo) {
        super(nickName, score);

        this.Mail = mail;
        this.DSGVO = dsgvo;
    }
}
