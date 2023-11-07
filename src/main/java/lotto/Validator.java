package lotto;

import lotto.message.ErrorMessage;

import java.util.List;

public class Validator {
    public static void validateIsInt(String input) {
        if (input == null && !input.matches("\\d*")) {
            throw new IllegalArgumentException(ErrorMessage.NON_INTEGER_INPUT.getMessage());
        }
    }

    public static void validatePaymentAmount(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNAFFORDABLE_PRICE.getMessage());
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SIZE_OF_LOTTO.getMessage());
        }
    }
}
