package lotto;

import lotto.enums.ErrorMessage;

import java.util.List;

public class Validation {
    public static void validateNotNull(List<Integer> input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getMessage());
        }
    }

    public static void validateNaturalNumber(String input) {
        boolean isInteger = input.trim().matches("^[0-9]+$");
        if (!isInteger || Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public static void validateNaturalNumber(List<String> input) {
        input.forEach(Validation::validateNaturalNumber);
    }
}
