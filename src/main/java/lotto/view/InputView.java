package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.ValidationUtils;

public class InputView {
    public long readPurchaseAmount() {
        String purchaseAmountInput = Console.readLine();
        return ValidationUtils.validateLong(purchaseAmountInput);
    }

    public int readWinningNumbers() {
        String winningNumbersInput = Console.readLine();

    }

    public int readBonusNumber() {
        String bonusNumberInput = Console.readLine();
        return ValidationUtils.validateInteger(bonusNumberInput);
    }
}
