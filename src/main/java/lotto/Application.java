package lotto;

import lotto.view.MessagePrinter;

public class Application {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new MessagePrinter();
        GameManager gameManager = new GameManager(messagePrinter);
        gameManager.startGame();
    }
}
