
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Die Klasse InputManager ist für die Benutzereingaben verantwortlich.
 * 
 * @author Georg Vogelhuber
 * @version 01.11.2021
 */
public class InputManager
{
    private BufferedReader Reader;
    
    public InputManager() {
        this.Reader =new BufferedReader(new InputStreamReader(System.in));
    }
    
    /**
     * Erfragt vom Benutzer den nächsten Buchstaben. 
     * Es werden nur Großbuchstaben akzeptiert
     * 
     * @return Den geratenen Buchstaben als char
     */
    public char getNextGuess() throws IOException {
        char guess = 0;
        boolean valid = false;
        
        do {
            System.out.print("Bitte Großbuchstaben eingeben : ");
            guess = this.Reader.readLine().charAt(0);
            valid = ( guess >= 65 && guess <= 90);
            if(!valid) {
                System.out.println("Ungültige Eingabe!");
            }
        } while(!valid);
        
        return guess;
    }
}
