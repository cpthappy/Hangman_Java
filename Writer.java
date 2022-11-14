
/**
 * Bie Klasse Writer ist für die Ausgabe zuständig.
 * 
 * @author Georg Vogelhuber 
 * @version 01.11.2021
 */
public class Writer
{
    /**
     * Ausgabe der Meldung für den Spielbeginn
     */
    public void writeGreeting() {
        System.out.println("Hangman - finde das geheime Wort");
    }
    
    /**
     * Den aktuellen Zustand des Spiels ausgeben
     */
    public void writeGameState(Word guessWord, int wrongGuesses) {
        System.out.println(guessWord.getDisplayValue());
        System.out.println("bisher "+ wrongGuesses+ " Fehlversuche");
    }
    
    /**
     * Ausgabe für das Ende des Spiels
     */
    public void writeGameEnd(Word guessWord, int wrongGuesses) {
        System.out.println(guessWord.getDisplayValue());
        System.out.println("Mit "+wrongGuesses + " Fehlversuchen gefunden");
    }

    public void writeHighScorePosition(String nickName, int position, int wrongGuesses) {
    }

    public void writeHighScores(Highscore highScore, int i) {
    }
}
