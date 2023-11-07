package lotto.config;

import java.util.List;
import lotto.vo.WinningNumbers;
import lotto.util.handler.InputHandler;
import lotto.util.parser.MultiNumbersParser;
import lotto.util.parser.SingleNumberParser;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.WinningNumbersValidator;
import lotto.view.facade.AmountViewFacade;
import lotto.view.facade.BonusNumberViewFacade;
import lotto.view.facade.WinningNumbersViewFacade;

public class InputConfiguration {
    public static InputHandler<Integer> createAmountInputHandler() {
        return new InputHandler<>(
                new SingleNumberParser(),
                new AmountValidator(),
                new AmountViewFacade()
        );
    }

    public static InputHandler<List<Integer>> createWinningNumbersInputHandler() {
        return new InputHandler<>(
                new MultiNumbersParser(),
                new WinningNumbersValidator(),
                new WinningNumbersViewFacade()
        );
    }

    public static InputHandler<Integer> createBonusNumberInputHandler(WinningNumbers winningNumbers) {
        return new InputHandler<>(
                new SingleNumberParser(),
                new BonusNumberValidator(winningNumbers),
                new BonusNumberViewFacade()
        );
    }
}
