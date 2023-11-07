package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumberValidator;
import lotto.validator.PurchaseAmountValidator;

public class InputView {

    private final OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    public long getPurchaseAmount() {
        try {
            outputView.printRequestPurchaseAmount();
            String purchaseAmount = getInput();
            return PurchaseAmountValidator.validate(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public String getWinningNumbers() {
        try {
            outputView.printRequestWinningNumbers();
            String winningNumbers = getInput();
            LottoNumberValidator.isValid(LottoNumberValidator.convertStringToList(winningNumbers));
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(String winningNumbersInput) {
        try {
            outputView.printRequestBonusNumber();
            String bonusNumberInput = Console.readLine();
            return BonusNumberValidator.validate(bonusNumberInput, winningNumbersInput);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbersInput);
        }
    }

    private String getInput() {
        return Console.readLine();
    }
}
