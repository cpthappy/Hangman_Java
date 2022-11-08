import java.io.IOException;
/**
 * Die Klasse Game verwaltet den Zustand des Spiels und steuert den Ablauf.
 * 
 * @author Georg Vogelhuber 
 * @version 01.11.2021
 */
public class Game
{
    private Wordlist WordList;
    private Writer Writer;
    private InputManager InputManager;
    private Word CurrentWord;
    private int WrongGuesses;

    /**
     * Konstruktor für Objekte der Klasse Game
     */
    public Game() throws IOException
    {
        this.Writer = new Writer();
        this.InputManager = new InputManager();
        this.WordList = new Wordlist("Wordlist.txt");
    }
    
    /**
     * Neues Spiel initialisieren. Zähler und Word zurücksetzen.
     */
    private void initNewGame() {
        this.CurrentWord = this.WordList.getRandomWord();
        this.WrongGuesses = 0;
    }

    /**
     * Spiel durchführen
     */
    public void runGame() throws IOException{
        this.initNewGame();
        this.Writer.writeGreeting();
        while (!this.CurrentWord.isComplete()) {
            this.Writer.writeGameState(this.CurrentWord, this.WrongGuesses);
            char guess = this.InputManager.getNextGuess();
            boolean isCorrect = this.CurrentWord.guessLetter(guess);
            if(!isCorrect) {
                this.WrongGuesses++;
            }
        }
        this.Writer.writeGameEnd(this.CurrentWord, this.WrongGuesses);
    }
}
