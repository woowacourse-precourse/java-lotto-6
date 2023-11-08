package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;

/**
 * 로또 번호를 검증한다.
 */
public class LottoNumberValidator {

    /**
     * 로또 번호의 개수를 검증한다.
     *
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 6개가 아닌 경우
     */
    public static void checkCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 로또 번호가 범위 내인지 확인한다.
     *
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 1 ~ 45번이 아닌 경우
     */
    public static void checkRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkMinimum(number);
            checkMaximum(number);
        }
    }

    private static void checkMinimum(Integer number) {
        if (number < MINIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage());
        }
    }

    private static void checkMaximum(Integer number) {
        if (number > MAXIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage());
        }
    }

    /**
     * 중복된 번호가 있는지 검증한다.
     *
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 중복된 번호가 존재하는 경우
     */
    public static void checkDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
