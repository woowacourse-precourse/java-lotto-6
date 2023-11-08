package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.NumberUtil;
import lotto.validate.ValidateInput;

public class InputView {

    public static int inputPurchaseAmount() {
        String purchaseAmount = input();
        ValidateInput.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputWinningNumber() {
        String inputNumber = input();
        ValidateInput.validateWinningNumber(inputNumber);
        return NumberUtil.toListInteger(inputNumber);
    }

    public static Integer inputBonusNumber() {
        String input = input();
        ValidateInput.validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    public static String input() {
        return Console.readLine();
    }
}
