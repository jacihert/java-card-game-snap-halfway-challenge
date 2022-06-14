import java.util.*;

public class CardGame {

// attributes  // name of the game  // deck of cards
    private String nameOfTheGame;
    private String [] suits = {"♥","♣","♦","♠"} ;
    private String [] symbols = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"} ;
    private int [] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    protected ArrayList<Card> deckOfCards = new ArrayList<> ();
    private ArrayList<Card> cards = new ArrayList<>();
    private int cardNumber = 0;
    private Card dealCard;


    // constructor
    public CardGame(String nameOfTheGame) {
        this.nameOfTheGame = nameOfTheGame;
    }

    // getDeck method
    public ArrayList<Card> getDeck() {
        System.out.println("get deck : " + deckOfCards);
        return deckOfCards;
    }
// makeDeck method
    public void  makeDeck () {
//        for ( char suit: suits) {
        for ( String suit: suits) {
            for (int i = 0; i < symbols.length; i++)  {
                Card card = new Card(suit, symbols[i], values[i]);
//                System.out.println(suit + " " + symbols[i] + " "  + values[i]);
//                System.out.println(myCard);
                deckOfCards.add(card);
            }
        }
        cardNumber = 0;
//        System.out.println("make - deck : " + deckOfCards);
    }

    // shuffleDeck method
        public void shuffleDeck() {
            Collections.shuffle(deckOfCards);
//            System.out.println("Shuffled - Deck : " + deckOfCards);

//    • ArrayList<Card> shuffleDeck() - shuffles the deck into a random order and stores the
//new shuffled deck back into the deckOfCards attribute

        }

    // dealCard method
    public Card dealCard(){
//        System.out.println("shuffled - deck before shuffle & getting deal card : " + deckOfCards);
//        shuffleDeck();
//        System.out.println("shuffled - deck before getting deal card : " + deckOfCards);
        dealCard = deckOfCards.get(cardNumber) ;
        System.out.println(dealCard);
        if (cardNumber == 51) {
            shuffleDeck();
            cardNumber=1;
        } else {
        cardNumber += 1;}
        return dealCard;
    }

        //option 2 : generate a random number between 0 & length oif the arraylist -1 -> 51
////        int randomNum = (int) Math.floor(Math.random() * deckOfCards.size()+1);
////        return deck.get(randomNum);

    // sort
    public void sortDeckInNumberOrder() {
        System.out.println("before number sort : " + deckOfCards);
        Collections.sort(deckOfCards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {return card1.getValue() - card2.getValue();
            }

        });
        System.out.println("number sorted cards : " + deckOfCards);

        ////    • ArrayList<Card> sortDeckInNumberOrder() - sorts the deck in number order (e.g.
////2222333344445555 etc) and stores the new shuffled deck back into the deckOfCards attribute

    }

    public void sortDeckIntoSuits(){
        System.out.println("before suit : " + deckOfCards);
        Collections.sort(deckOfCards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return card1.getSuit().compareTo(card2.getSuit());
//                card1.getValue() - card2.getValue();
            }
        });
        Collections.sort(deckOfCards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return card1.getValue() - card2.getValue();
            }
        });
        System.out.println("suits sorted cards : " + deckOfCards);

//    • ArrayList<Card> sortDeckIntoSuits() - sorts the deck into suits (2,3,4,5,6,7,8,9,10,J,Q,K,A
//            of hearts, then 2,3,4,5,6,7,8,9,10,J,Q,K,A of clubs etc.) and stores the new shuffled deck
//    back into the deckOfCards attribute

    }




// toString method for sout

    @Override
    public String toString() {
        return "CardGame{" +
                "nameOfTheGame='" + nameOfTheGame + '\'' +
                ", suits=" + Arrays.toString(suits) +
                ", symbols=" + Arrays.toString(symbols) +
                ", values=" + Arrays.toString(values) +
                ", deckOfCards=" + deckOfCards +
                ", cards=" + cards +
                '}';
    }

}

//    CardGame
//• - Contains an ArrayList<Card> for the deckOfCards that contains all 52 cards. This is
//    created and populated when the game is constructed.
//            • - Has a name which is also defined in the constructor.
//            • - Has a getDeck method that lists out the cards in the deck.
