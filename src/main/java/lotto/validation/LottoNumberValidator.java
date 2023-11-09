package lotto.validation;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

public class LottoNumberValidator {

    public static void validateLottoNumber(List<Integer> numbers) {
        validateWinningNumbersCount(numbers);
        validateDuplicate(numbers);
        validateNumbersRange(numbers);
    }

    public static void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
    }

    public static void validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private static void validateRange(int number) {
        GameConfig minNumber = GameConfig.MIN_LOTTO_NUMBER;
        GameConfig maxNumber = GameConfig.MAX_LOTTO_NUMBER;

        if (number < minNumber.getValue() || number > maxNumber.getValue()) {
            ExceptionMessage message = ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private static void validateWinningNumbersCount(List<Integer> numbers) {
        GameConfig winningNumbersCount = GameConfig.WINNING_NUMBERS_COUNT;

        if (numbers.size() != winningNumbersCount.getValue()) {
            ExceptionMessage message = ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> deduplicatedNumbers = new HashSet<>(numbers);

        if (deduplicatedNumbers.size() != numbers.size()) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }
}
