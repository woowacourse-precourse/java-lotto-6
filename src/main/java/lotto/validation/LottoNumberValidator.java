package lotto.validation;

import lotto.domain.WinningNumbers;
import lotto.utility.TypeConverter;

import java.util.List;

import static lotto.configuration.RandomNumberConfig.END_INCLUSIVE;
import static lotto.configuration.RandomNumberConfig.START_INCLUSIVE;
import static lotto.message.ErrorMessage.*;

public class LottoNumberValidator {
    public static void validateDuplicateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            matchTwoNumbers(numbers, i);
        }
    }

    public static void validateDuplicateNumbers(String bonusNumber, WinningNumbers winningNumbers) {
        int parsedBonusNumber = TypeConverter.convertStringToInt(bonusNumber);
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (parsedBonusNumber == winningNumbers.get(i)) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE_HEAD + DUPLICATE_NUMBER_EXCEPTION + (i + 1) + NUMBER_INDICATION + bonusNumber
                );
            }
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + NUMBER_OUT_OF_RANGE_EXCEPTION + number);
            }
        }
    }

    public static void validateNumberRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + NUMBER_OUT_OF_RANGE_EXCEPTION + number);
        }
    }

    public static void validateNumbersOrder(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE_HEAD + INVALID_NUMBERS_ORDER_EXCEPTION
                                + (i + 1) + NUMBER_INDICATION + numbers.get(i) + ", "
                                + (i + 2) + NUMBER_INDICATION + numbers.get(i + 1)
                );
            }
        }
    }

    private static void matchTwoNumbers(List<Integer> numbers, int i) {
        for (int j = i + 1; j < numbers.size(); j++) {
            if (numbers.get(i) == numbers.get(j)) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE_HEAD + DUPLICATE_NUMBER_EXCEPTION
                                + (i + 1) + NUMBER_INDICATION + numbers.get(i) + ", "
                                + (j + 1) + NUMBER_INDICATION + numbers.get(j)
                );
            }
        }
    }
}
