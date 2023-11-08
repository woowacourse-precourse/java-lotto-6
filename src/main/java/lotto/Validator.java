package lotto;

import lotto.message.ErrorMessage;

import java.util.List;

public class Validator {
    public static String validateIsInt(String input) throws IllegalArgumentException {
        if (input != null && input.matches("^[0-9]+$")) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public static void validatePaymentAmount(int input) {
        if (input <= 0 || input % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNAFFORDABLE_PRICE.getMessage());
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SIZE_OF_LOTTO.getMessage());
        }
    }

    public static void validateUniqueValues(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_VALUES_EXIST.getMessage());
        }
    }

    public static void validateValueBound(List<Integer> numbers) {
        numbers.stream().sorted();
        if(numbers.get(0) <= 0 || numbers.get(5) > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_VALUE_OUT_OF_BOUNDS.getMessage());
        }
    }
}
