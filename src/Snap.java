import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {
    private Scanner myScanner = new Scanner(System.in);
    private Card previousCard;
    private String currentCardSymbol;
    private String previousCardSymbol;
    private Card currentCard;
    private String currentPlayer;
    private ArrayList<String> players = new ArrayList<>();

    private Scanner MyScanner = new Scanner(System.in);
    private double snapStart;
    private double snapTime;

    public Snap(String nameOfTheGame) {
        super(nameOfTheGame);
    }

    public void snap() {
        this.makeTeam();
        this.makeDeck();
        this.shuffleDeck();
        this.setPlayer();
    }

    public void makeTeam() {
        Player player1 = new Player("My Snap game", "Hoppy", "Rabbit");
        Player player2 = new Player("My Snap game", "Swimmy", "Fish");
        players.add(player1.getFullName());
        players.add(player2.getFullName());

        System.out.println("Hey there, come on ! Let's play !");
        System.out.println("This game will be played by the 2 players : " + players.get(0) + " & " + players.get(1));
        System.out.println();
    }

    public void setPlayer() {
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        } else if (currentPlayer == players.get(0)) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
        this.play();
    }

    public void play() {
        previousCard = currentCard;

        System.out.println();
        System.out.println();
        System.out.println("Hey " + currentPlayer + " press 'ENTER' to play your turn");
        String enter = myScanner.nextLine();

        currentCard = this.dealCard();
        currentCardSymbol = currentCard.getSymbol();

        if (previousCard != null) {
            previousCardSymbol = previousCard.getSymbol();
        }

        checkSnap();
    }

    public void checkSnap() {
        if (currentCardSymbol == previousCardSymbol) {
            snapStart = System.currentTimeMillis();

            String isSnap = myScanner.next();
            snapTime = System.currentTimeMillis();

            if (isSnap.toLowerCase().equalsIgnoreCase("snap") && ((snapTime - snapStart) <= 120000)) {
                System.out.println("   S N A P    !      Game over. " + currentPlayer + "  Y O U     W I N   !  ****   ");

            } else {
                System.out.println(" Oops ! you missed it ! Keep trying ! Press 'Enter' to continue");

                this.setPlayer();
            }
        } else {
            this.setPlayer();
        }
    }

}