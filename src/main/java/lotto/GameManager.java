package lotto;

import lotto.view.MessagePrinter;

public class GameManager {

    private final MessagePrinter messagePrinter;

    public GameManager(final MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public void startGame() {
        prepareGame();
    }

    private void prepareGame() {
        messagePrinter.printBuyingPriceMessage();
    }
}
