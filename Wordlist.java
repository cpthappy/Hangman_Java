import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Die Klasse Wordlist dient zur Verwaltung aller möglichen Wörter,
 * die im Spiel verwendet werden können.
 * 
 * @author Georg Vogelhuber
 * @version 01.11.2021
 */
public class Wordlist
{
    private String[] Words;
    private String FilePath;
    
    private Random RandomGenerator;

    /**
     * Konstruktor für Objekte der Klasse Wordlist
     * 
     * @param filePath Pfad zur Datei mit den möglichen Wörtern
     */
    public Wordlist(String filePath) throws IOException{
    
        this.FilePath = filePath;
        this.RandomGenerator = new Random();
        this.read();
    }
    
    /**
     * Mit dieser Methode wird die Wortliste ausgelesen.
     */
    private void read() throws IOException{
        FileReader fileReader = new FileReader(this.FilePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        Words = lines.toArray(new String[lines.size()]);
    }
    
    /**
     * Einen zufälligen Index der Wortliste erzeugen
     * 
     * @return eine zufällige Zahl zwischen 0 und Länge der Wortliste
     */
    private int getRandomIndex() {
        int max = this.Words.length-1;
        return this.RandomGenerator.nextInt(max + 1);
    }
    
    /**
     * Liefert ein zufälliges Wort aus der Liste.
     * 
     * @return Ein Wort aus der Liste
     */
    public Word getRandomWord() {
        return new Word(this.Words[this.getRandomIndex()]);
    }
   
}
