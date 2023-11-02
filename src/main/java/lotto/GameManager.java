package lotto;

import lotto.view.MessagePrinter;
import lotto.view.MessageReceiver;

public class GameManager {

    private final MessagePrinter messagePrinter;
    private final MessageReceiver messageReceiver;

    public GameManager(final MessagePrinter messagePrinter, final MessageReceiver messageReceiver) {
        this.messagePrinter = messagePrinter;
        this.messageReceiver = messageReceiver;
    }

    public void startGame() {
        prepareGame();
    }

    private void prepareGame() {
        messagePrinter.printBuyingPriceMessage();
        messageReceiver.receiveBuyingPrice();
    }
}
