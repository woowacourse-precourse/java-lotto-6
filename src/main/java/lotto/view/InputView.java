package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.BonusInputValidator;
import lotto.util.validator.InputValidator;
import lotto.util.validator.PurchaseAmountInputValidator;
import lotto.util.validator.WinningInputValidator;

public class InputView {
    private static final InputValidator winningInputValidator = new WinningInputValidator();
    private static final InputValidator purchaseAmountInputValidator = new PurchaseAmountInputValidator();
    private static final InputValidator bonusInputValidator = new BonusInputValidator();

    public String readPurchaseAmount() {
        String input = Console.readLine();
        purchaseAmountInputValidator.validate(input);
        return input;
    }

    public String readWinningNumber() {
        String input = Console.readLine();
        winningInputValidator.validate(input);
        return input;
    }

    public String readBonusNumber() {
        String input = Console.readLine();
        bonusInputValidator.validate(input);
        return input;
    }
}
