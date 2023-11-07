package lotto;

import java.util.List;

import static lotto.constants.LottoConfig.NUMBER_LENGTH;

public class Validator {
    public static boolean isUniqueNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .toList().size() == NUMBER_LENGTH.getValue();
    }

    public static void validatePayment(String payment) {
        if (!payment.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    public static void containOnlyDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    public static void containOnlyDigit(String[] inputNumbers) {
        for (String input: inputNumbers) {
            containOnlyDigit(input);
        }
    }
}
