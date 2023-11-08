package lotto.validator;

import static lotto.controller.LottoController.LOTTO_PRICE;
import static lotto.message.ErrorMessage.*;

import java.util.List;

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
        if (money % LOTTO_PRICE != 0) {
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

    public static void isWinningNumberValid(String input) {
        isInputEmpty(input);
        isInputFormatValid(input);

        String[] separatedInput = input.split(",");
        for (int i = 0; i < separatedInput.length; i++) {
            isInputEmpty(separatedInput[i]);
            isNumeric(separatedInput[i]);
        }
    }

    public static void isInputFormatValid(String input) {
        int inputLength = input.length();
        if (input.charAt(0) == ',' || input.charAt(inputLength - 1) == ',') {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }
    }

    public static void isBonusNumberValid(String input) {
        isInputEmpty(input);
        isNumeric(input);
    }

    public static void isBonusNumberDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IN_BONUS_ERROR);
        }
    }

}
