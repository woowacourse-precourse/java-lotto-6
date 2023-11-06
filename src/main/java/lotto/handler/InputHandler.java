package lotto.handler;

import lotto.domain.BonusNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputHandler {

    private InputHandler() {
    }

    public static PurchasePrice receiveValidatedPurchasePrice() {
        while (true) {
            try {
                String purchasePrice = InputView.inputPurchasePrice();
                return PurchasePrice.from(purchasePrice);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessageFor(exception);
            }
        }
    }

    public static WinningNumber receiveValidatedWinningNumber() {
        while (true) {
            try {
                String winningNumber = InputView.inputWinningNumber();
                return WinningNumber.from(winningNumber);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessageFor(exception);
            }
        }
    }

    public static BonusNumber receiveValidatedBonusNumberAndNotExistFrom(WinningNumber winningNumber) {
        while (true) {
            try {
                String bonusNumber = InputView.inputBonusNumber();
                return BonusNumber.ofNotDuplicatedWithWinningNumber(bonusNumber, winningNumber);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessageFor(exception);
            }
        }
    }
}
