
/**
 * Die Klasse Word beinhaltet das zu ratende Wort und 
 * die bisher korrekt geratenen Buchstaben.
 * 
 * @author Georg Vogelhuber
 * @version 01.11.2021
 */
public class Word
{
    private String GuessWord;
    private char[] DisplayValue;

    /**
     * Konstruktor für Objekte der Klasse Word
     */
    public Word(String guessWord)
    {
        this.GuessWord = guessWord;
        this.DisplayValue = new char[this.GuessWord.length()];
        for (int i=0; i<this.DisplayValue.length;i++) {
            this.DisplayValue[i] = '_';
        }
    }
    
    /**
     * Den aktuellen Stand für die Ausgabe abrufen.
     * Die bisher nicht geratenen Buchstaben werden als _ angezeigt.
     * 
     * @return Das zu ratende Wort mit Platzhaltern.
     */
    public String getDisplayValue() {
        StringBuilder sb = new StringBuilder();
        for (char c : this.DisplayValue) {
            sb.append(c);
            sb.append(' ');
        }
        return sb.toString();
    }
    
    /** 
     * Prüfen, ob das Wort bereits vollständig erraten wurde.
     * 
     * @return true, wenn alle Buchstaben gefunden wurden
     */
    public boolean isComplete() {
        boolean isComplete = true;
        
        for (int i=0; i < this.DisplayValue.length; i++) {
            if(this.DisplayValue[i] == '_') {
                isComplete = false;
            }
        }
        
        return isComplete;
    }
    
    /**
     * Weiteren Buchstaben raten.
     * 
     * @param letter Dieser Buchstabe soll geraten werden
     * 
     * @return true, wenn der Buchstabe im Wort vorkommt
     */
    public boolean guessLetter(char letter) {
        boolean wordContainsLetter = false;
        
        for (int i=0;i<this.DisplayValue.length;i++) {
            if (this.GuessWord.charAt(i) == letter) {
                this.DisplayValue[i] = letter;
                wordContainsLetter = true;
            }
        }
        
        return wordContainsLetter;
    }
}
