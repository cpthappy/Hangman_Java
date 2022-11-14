import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CandidateWriter {
    public static void writeBewerberdaten(ExtendedPlayerData data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            
            writer.write("Name: "+ data.getNickName() + ", E-Mail: "+ data.getMail() +", DSGVO: " + data.getDSGVO());
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}
