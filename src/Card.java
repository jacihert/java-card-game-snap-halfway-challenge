import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Card {

// attributes  // symbol // value
//    private char suit ;
    private String suit ;
    private String symbol ;
    private int value ;

//    public Card(char suit, String symbol, int value) {
public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    // toString : class description


    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}


