package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.PurchaseValidator;
import lotto.util.validator.WinningNumberValidator;

import java.util.List;

public class InputView {
    private final PurchaseValidator purchaseValidator = new PurchaseValidator();
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    public long getPurchaseAmount() {
        String inputPurchaseAmount = Console.readLine();
        return purchaseValidator.validatePurchaseAmount(inputPurchaseAmount);
    }

    public List<Integer> getWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = winningNumberValidator.validateWinningNumbers(inputWinningNumbers);
        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = Console.readLine();
        return bonusNumberValidator.validateBonusNumber(inputBonusNumber, winningNumbers);
    }
}