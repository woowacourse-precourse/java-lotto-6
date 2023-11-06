package lotto.validator;

import static lotto.exception.ErrorMessage.*;

import lotto.controller.LottoController;

public class Validator {
    private Validator() {
    }

    public static void isPurchaseAmountValid(String input) {
        isInputEmpty(input);
        isNumeric(input);
        int purchaseAmount = Integer.parseInt(input);
        isDividedByLottoPrice(purchaseAmount);
    }

    public static void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(NO_INPUT_ERROR);
        }
    }

    public static void isDividedByLottoPrice(int money) {
        if (money % LottoController.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT_ERROR);
        }
    }

    public static void isNumeric(String input) {
        if (!(input.charAt(0) >= '1' && input.charAt(0) <= '9')) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }
        for (int i = 1; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
            }
        }
    }
}
