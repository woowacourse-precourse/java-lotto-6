package lotto.config;

import lotto.GameManager;
import lotto.view.MessagePrinter;
import lotto.view.MessageReceiver;
import lotto.view.valid.ViewValidator;

public class GameConfig {

    public static GameManager buildGameManager() {
        ViewValidator viewValidator = viewValidator();
        MessageReceiver messageReceiver = messageReceiver(viewValidator);
        MessagePrinter messagePrinter = messagePrinter();

        return new GameManager(messagePrinter, messageReceiver);
    }

    private static ViewValidator viewValidator() {
        return new ViewValidator();
    }

    private static MessagePrinter messagePrinter() {
        return new MessagePrinter();
    }

    private static MessageReceiver messageReceiver(final ViewValidator viewValidator) {
        return new MessageReceiver(viewValidator);
    }
}
