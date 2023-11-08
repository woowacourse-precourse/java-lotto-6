package lotto.Utils;

public class InputSystem {
    public static int inputPurchaseMoney() throws IllegalArgumentException {
        return Validator.validateNumber(SystemConstants.INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static String[] inputWinningNumbers() {
        return Validator.validateSixWinningNumbers(SystemConstants.INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static int inputBonusNumber() {
        return Validator.validateNotContainWinningNumbers(SystemConstants.INPUT_BONUS_MESSAGE);
    }
}
