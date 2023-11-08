package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ConvertUtil;
import lotto.util.validator.BonusInputValidator;
import lotto.util.validator.InputValidator;
import lotto.util.validator.PurchaseAmountInputValidator;
import lotto.util.validator.WinningInputValidator;

import java.util.List;

public class InputView {
    private static final InputValidator winningInputValidator = new WinningInputValidator();
    private static final InputValidator purchaseAmountInputValidator = new PurchaseAmountInputValidator();
    private static final InputValidator bonusInputValidator = new BonusInputValidator();

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        purchaseAmountInputValidator.validate(input);
        return ConvertUtil.convertInputToPurchaseAmount(input);
    }

    public static List<Integer> readWinningNumber() {
        String input = Console.readLine();
        winningInputValidator.validate(input);
        return ConvertUtil.convertInputToIntegerLottoNumbers(input);
    }

    public static int readBonusNumber() {
        String input = Console.readLine();
        bonusInputValidator.validate(input);
        return ConvertUtil.convertInputToBonusNumber(input);
    }
}
