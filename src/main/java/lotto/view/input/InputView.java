package lotto.view.input;

import java.util.List;

public class InputView {
    private PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();
    private WinningNumbersInputView winningNumbersInputView = new WinningNumbersInputView();
    private BonusNumberInputView bonusNumberInputView = new BonusNumberInputView();

    public int getPurchaseAmount() {
        return purchaseAmountInputView.getInput();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbersInputView.getInput();
    }

    public int getBonusNumber() {
        return bonusNumberInputView.getInput();
    }
}
