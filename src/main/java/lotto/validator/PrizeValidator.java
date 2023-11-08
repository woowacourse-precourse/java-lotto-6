package lotto.validator;

import static lotto.enums.ExceptionCase.INPUT_TYPE_MISMATCH;
import static lotto.enums.ExceptionCase.NUMBER_DUPLICATION;
import static lotto.enums.ExceptionCase.NUMBER_OUT_OF_RANGE;
import static lotto.enums.NumberCondition.LOTTO_MAX;
import static lotto.enums.NumberCondition.LOTTO_MIN;
import static lotto.enums.RegularExpression.NUMBERS_AND_COMMA;
import static lotto.enums.RegularExpression.POSITIVE_INTEGER;

import java.util.List;
import lotto.model.Lotto;

public class PrizeValidator {

    public static void validateNumbers(String numbers) {
        if (!isNumbers(numbers)) {
            throw new IllegalArgumentException(INPUT_TYPE_MISMATCH.message());
        }
    }

    public static void validateBonusNumber(String number, Lotto lotto) {
        if (!isPositiveInteger(number)) {
            throw new IllegalArgumentException(INPUT_TYPE_MISMATCH.message());
        }
        int bonusNumber = Integer.parseInt(number);
        if (!inRange(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
        }
        if (!unique(bonusNumber, lotto)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION.message());
        }
    }

    private static boolean isPositiveInteger(String number) {
        return number.matches(POSITIVE_INTEGER.regex());
    }

    private static boolean isNumbers(String numbers) {
        return numbers.matches(NUMBERS_AND_COMMA.regex());
    }

    private static boolean inRange(int bonusNumber) {
        return bonusNumber >= LOTTO_MIN.number() && bonusNumber <= LOTTO_MAX.number();
    }

    private static boolean unique(int bonusNumber, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return !numbers.contains(bonusNumber);
    }

}
