package lotto.game;

public class LottoGame {

    private static final int PRICE = 1000;
    private final int inputNumber;

    public LottoGame(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getNumberOfGames() {
        return inputNumber / PRICE;
    }


}
