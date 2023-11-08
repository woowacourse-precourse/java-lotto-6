package lotto.view;

import static lotto.util.content.DisplayMessage.NEXT_LINE;
import static lotto.util.content.DisplayMessage.SET_BONUS_NUMBER;
import static lotto.util.content.DisplayMessage.SET_PURCHASE_AMOUNT;
import static lotto.util.content.DisplayMessage.SET_WIN_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.validation.ViewCensor;

public class InputView {

    public static String purchaseAmount() {
        System.out.println(SET_PURCHASE_AMOUNT.getContent());
        String input = Console.readLine();
        try {
            ViewCensor.validatePurchase(input);
        } catch (IllegalArgumentException e) {
            OutputView.displayErrorMessage(e);
            purchaseAmount();
        }
        return input;
    }

    public static String winningNumbers() {
        System.out.println(NEXT_LINE.getContent() + SET_WIN_NUMBERS.getContent());
        String input = Console.readLine();
        try {
            ViewCensor.validateWinningNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.displayErrorMessage(e);
            winningNumbers();
        }
        return input;
    }

    public static String bonusNumber(Lotto number) {
        System.out.println(NEXT_LINE.getContent() + SET_BONUS_NUMBER.getContent());
        String input = Console.readLine();
        try {
            ViewCensor.validateBonusNumber(input, number);
        } catch (IllegalArgumentException e) {
            OutputView.displayErrorMessage(e);
            bonusNumber(number);
        }
        return input;
    }

}
