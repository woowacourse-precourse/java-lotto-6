package lotto.view;

import static lotto.util.content.DisplayMessage.NEXT_LINE;
import static lotto.util.content.DisplayMessage.SET_PURCHASE_AMOUNT;
import static lotto.util.content.DisplayMessage.SET_WIN_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Censor;

public class InputView {

    public static String purchaseAmount() {
        System.out.println(SET_PURCHASE_AMOUNT.getContent());
        return Censor.validatePurchaseAmount(Console.readLine());
    }

    public static String winningNumbers() {
        System.out.println(NEXT_LINE.getContent() + SET_WIN_NUMBERS.getContent());
        return Censor.validateWinningNumbers(Console.readLine());
    }

}
