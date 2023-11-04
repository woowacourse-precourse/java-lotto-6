package lotto.config;

import lotto.GameManager;
import lotto.view.MessagePrinter;
import lotto.view.MessageReceiver;
import lotto.view.valid.BonusNumberValidation;
import lotto.view.valid.BuyingPriceValidation;
import lotto.view.valid.ViewValidator;
import lotto.view.valid.WinningNumberValidation;

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
        BuyingPriceValidation buyingPriceValidation = buyingPriceValidation();
        WinningNumberValidation winningNumberValidation = winningNumberValidation();
        BonusNumberValidation bonusNumberValidation = bonusNumberValidation();

        return new MessageReceiver(viewValidator, buyingPriceValidation,
                winningNumberValidation, bonusNumberValidation);
    }

    private static BuyingPriceValidation buyingPriceValidation() {
        return new BuyingPriceValidation();
    }

    private static WinningNumberValidation winningNumberValidation() {
        return new WinningNumberValidation();
    }

    private static BonusNumberValidation bonusNumberValidation() {
        return new BonusNumberValidation();
    }
}
