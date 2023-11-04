package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    public Integer inputPurchaseAmount() {
        String amount = Console.readLine();
        InputValidator.validatePurchaseAmount(amount);

        return Integer.valueOf(amount);
    }

    public String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        InputValidator.validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    public Integer inputBonusNumbers() {
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);

        return Integer.valueOf(bonusNumber);
    }
}
