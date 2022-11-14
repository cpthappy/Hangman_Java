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
    private Highscore HighScore;

    /**
     * Konstruktor für Objekte der Klasse Game
     */
    public Game() throws IOException
    {
        this.Writer = new Writer();
        this.InputManager = new InputManager();
        this.WordList = new Wordlist("Wordlist.txt");
        this.HighScore = new Highscore("highscores.txt");
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

        String nickName = this.InputManager.getNickName();
        String mail = "";
        Boolean dsgvo = false;
        int position = -1;
        if (this.InputManager.getEmailEingeben()) {
            mail = this.InputManager.getEmail();
            dsgvo = this.InputManager.getDSGVO();
        }

        if (nickName.length()>0 && !(mail.length()>0 && dsgvo)) {
            PlayerData entry = new PlayerData(nickName, this.WrongGuesses);
            position = this.HighScore.addNewEntry(entry);
        } else if(nickName.length()>0 && (mail.length()>0 && dsgvo)) {
            ExtendedPlayerData entry = new ExtendedPlayerData(nickName, this.WrongGuesses, mail, dsgvo);
            position = this.HighScore.addNewEntry(entry);
            CandidateWriter.writeBewerberdaten(entry, "bewerbert.txt");
        }

        this.Writer.writeHighScorePosition(nickName, position, this.WrongGuesses);
        this.Writer.writeHighScores(this.HighScore, 5);
        this.HighScore.save();

    }


}
