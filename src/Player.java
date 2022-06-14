public class Player extends Snap {
    private String firstName;
    private String secondName;
    private String fullName;

    public Player(String nameOfTheGame, String firstName, String secondName) {
        super(nameOfTheGame);
        this.firstName = firstName;
        this.secondName = secondName;
        this.fullName = fullName;
    }

public String getFullName() {
        fullName = firstName + " " +  secondName;
        return fullName;
}

}

