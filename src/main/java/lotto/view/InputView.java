package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ConsoleMessage;
import lotto.util.Validator;

import java.util.List;

public class InputView {
    public static int inputPurchaseAmount() {
        try {
            OutputView.printInputMessage(ConsoleMessage.INPUT_PURCHASE_AMOUNT);
            return Validator.isValidPurchaseAmount(Console.readLine());
        } catch (IllegalArgumentException ex) {
            OutputView.printExceptionMessage(ex.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            OutputView.printInputMessage(ConsoleMessage.INPUT_WINNING_NUMBERS);
            return Validator.isValidWinningNumbers(Console.readLine());
        } catch (IllegalArgumentException ex) {
            OutputView.printExceptionMessage(ex.getMessage());
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber() {
        try {
            OutputView.printInputMessage(ConsoleMessage.INPUT_BONUS_NUMBER);
            return Validator.isValidBonusNumber(Console.readLine());
        } catch (IllegalArgumentException ex) {
            OutputView.printExceptionMessage(ex.getMessage());
            return inputBonusNumber();
        }
    }
}
