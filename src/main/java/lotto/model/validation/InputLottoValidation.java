package lotto.model.validation;

import lotto.utils.Constants;
import lotto.view.ExceptionMessage;

public class InputLottoValidation {
    private final int amount;

    public InputLottoValidation(int amount) {
        this.amount = amount;
    }
    public static int validateInput(String inputMoney) {
        int amount = validateNumber(inputMoney);
        validateNatural(amount);
        validateDivisible(amount);
        return amount;
    }

    public int calculateLottoCount() {
        return amount / Constants.LOTTO_TICKET_PRICE;
    }

    private static int validateNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }

    private static void validateNatural(int amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER_ERROR.getMessage());
        }
    }

    private static void validateDivisible(int amount) throws IllegalArgumentException {
        if (amount % Constants.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR.getMessage());
        }
    }
}
