package lotto;

public class Application {

    static Bonus bonus;
    static Lotto lotto;
    static Money money;

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame(money, lotto, bonus);
        playGame.sumOfMoney();
    }

}