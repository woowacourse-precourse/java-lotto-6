package lotto.config;

import lotto.GameManager;
import lotto.view.MessagePrinter;
import lotto.view.MessageReceiver;
import lotto.view.valid.BonusNumberValidation;
import lotto.view.valid.BuyingPriceValidation;
import lotto.view.valid.ViewValidator;
import lotto.view.valid.WinningNumberValidation;

public class GameConfig {

    private GameConfig() {
    }

    public static GameManager buildGameManager() {
        MessagePrinter messagePrinter = messagePrinter();
        MessageReceiver messageReceiver = messageReceiver();

        return new GameManager(messagePrinter, messageReceiver);
    }

    private static MessagePrinter messagePrinter() {
        return new MessagePrinter();
    }

    private static MessageReceiver messageReceiver() {
        ViewValidator viewValidator = viewValidator();
        BuyingPriceValidation buyingPriceValidation = buyingPriceValidation();
        WinningNumberValidation winningNumberValidation = winningNumberValidation();
        BonusNumberValidation bonusNumberValidation = bonusNumberValidation();

        return new MessageReceiver(viewValidator, buyingPriceValidation,
                winningNumberValidation, bonusNumberValidation);
    }

    private static ViewValidator viewValidator() {
        return new ViewValidator();
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
