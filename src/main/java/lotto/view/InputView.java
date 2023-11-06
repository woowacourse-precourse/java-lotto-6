package lotto.view;

import static lotto.util.Censor.validatePurchaseAmount;
import static lotto.util.Censor.validateWinningNumbersInput;
import static lotto.util.content.DisplayMessage.NEXT_LINE;
import static lotto.util.content.DisplayMessage.SET_PURCHASE_AMOUNT;
import static lotto.util.content.DisplayMessage.SET_WIN_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String purchaseAmount() {
        System.out.println(SET_PURCHASE_AMOUNT.getContent());
        return validatePurchaseAmount(Console.readLine());
    }

    public static String winningNumbers() {
        System.out.println(NEXT_LINE.getContent() + SET_WIN_NUMBERS.getContent());
        return validateWinningNumbersInput(Console.readLine());
    }

}
