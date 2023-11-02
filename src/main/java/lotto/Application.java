package lotto;

import lotto.view.MessagePrinter;
import lotto.view.MessageReceiver;
import lotto.view.ViewValidator;

public class Application {

    public static void main(String[] args) {
        ViewValidator viewValidator = new ViewValidator();
        MessagePrinter messagePrinter = new MessagePrinter();
        MessageReceiver messageReceiver = new MessageReceiver(viewValidator);

        GameManager gameManager = new GameManager(messagePrinter, messageReceiver);
        gameManager.startGame();
    }
}
