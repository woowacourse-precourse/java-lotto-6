package lotto.config;

import java.util.List;
import lotto.util.handler.InputHandler;
import lotto.util.parser.AmountParser;
import lotto.util.parser.WinningNumbersParser;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.WinningNumbersValidator;
import lotto.view.facade.AmountViewFacade;
import lotto.view.facade.WinningNumbersViewFacade;

public class InputConfiguration {
    public static InputHandler<Integer> createAmountInputHandler() {
        return new InputHandler<>(
                new AmountParser(),
                new AmountValidator(),
                new AmountViewFacade()
        );
    }

    public static InputHandler<List<Integer>> createWinningNumbersInputHandler() {
        return new InputHandler<>(
                new WinningNumbersParser(),
                new WinningNumbersValidator(),
                new WinningNumbersViewFacade()
        );
    }
}
