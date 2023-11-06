package lotto.utils;

import java.util.List;
import lotto.view.ExceptionMessages;

public class Validation {

    public static void validateStringToInteger(String string) {
        if (string.trim().isEmpty() || !string.chars().allMatch(Character::isDigit)) {
            ExceptionMessages.STRING_TO_INTEGER.throwException();
        }
    }

    public static void validateNumberInRange(int number, int min, int max) {
        if (number < min || number > max) {
            ExceptionMessages.NUMBER_IN_RANGE.throwException(min, max);
        }
    }

    public static void validateListNumberInRange(List<Integer> number, int min, int max) {
        if (number.stream().anyMatch(n -> n < min || n > max)) {
            ExceptionMessages.NUMBER_IN_RANGE.throwException(min, max);
        }
    }

    public static void validateNumberMultipleOf(int number, int multiple) {
        if (number % multiple != 0) {
            ExceptionMessages.INPUT_MULTIPLE_NUMBER.throwException(multiple);
        }
    }

    public static void validateListNumberNotDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            ExceptionMessages.DUPLICATED_NUMBER_IN_LIST.throwException();
        }
    }

    public static void validateListNumberCount(List<Integer> numbers, int count) {
        if (numbers.size() != count) {
            ExceptionMessages.INPUT_COUNT.throwException(count);
        }
    }

    public static void validateBonusNumberNotInWinningNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            ExceptionMessages.DUPLICATED_NUMBER_IN_LIST.throwException();
        }
    }
}
