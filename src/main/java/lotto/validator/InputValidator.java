package lotto.validator;

import lotto.message.ErrorMessage;

public class InputValidator {

    private static final int DENOMINATION = 1000;

    public void checkIsMultipleOfDenomination(int amount) {
        if (amount % DENOMINATION != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    public void checkIsValidLottoAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
        }
    }

    public int parseInt(String requestNumber) {
        int number;
        try {
            number = Integer.parseInt(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
        }
        return number;
    }
}
