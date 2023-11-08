package lotto.handler;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputHandler {

    private InputHandler() {
    }

    public static PurchasePrice receiveValidatedPurchasePrice() {
        return receiveValidatedInput(InputView::inputPurchasePrice, PurchasePrice::from);
    }

    public static WinningNumber receiveValidatedWinningNumber() {
        return receiveValidatedInput(InputView::inputWinningNumber, WinningNumber::from);
    }

    public static BonusNumber receiveValidatedBonusNumberAndNotExistFrom(WinningNumber winningNumber) {
        return receiveValidatedInput(InputView::inputBonusNumber,
                bonusNumber -> BonusNumber.ofNotDuplicatedWithWinningNumber(bonusNumber, winningNumber));
    }

    private static <T> T receiveValidatedInput(Supplier<String> inputView, Function<String, T> conversion) {
        while (true) {
            try {
                String input = inputView.get();
                return conversion.apply(input);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessageFor(exception);
            }
        }
    }
}
