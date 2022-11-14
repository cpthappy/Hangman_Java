
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

    public String getNickName() throws IOException{
        boolean valid = false;
        String name = "";
        do {
            System.out.print("Bitte gib deinen Nickname an: ");
            
            name = this.Reader.readLine();
            valid = name.length() > 0;

        } while(!valid);

        return name;
    }


    public String getEmail() throws IOException{
        boolean valid = false;
        String mail = "";
        do {
            System.out.print("Bitte gib deinen E-Mail-Adresse an: ");
            
            mail = this.Reader.readLine();
            valid = mail.length() > 0;
            valid &= mail.contains("@");

        } while(!valid);

        return mail;
    }

    public boolean getDSGVO() throws IOException {
      
        System.out.print("Bist du mit der Speicherung deiner E-Mail-Adresse einverstanden (j = JA): ");
        String eingabe = this.Reader.readLine();

        return eingabe.toLowerCase().charAt(0) == 'j';
    }


    public boolean getEmailEingeben() throws IOException {
      
        System.out.print("Möchtest du deine E-Mail Adresse auch angeben? (j = JA): ");
        String eingabe = this.Reader.readLine();

        return eingabe.toLowerCase().charAt(0) == 'j';
    }
}
