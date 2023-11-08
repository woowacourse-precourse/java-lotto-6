package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.BLANK_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.INVALID_NUMBER_OF_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;

/**
 * 당첨 번호를 검증한다.
 */
public class WinningNumberValidator {
    /**
     * 당첨 번호의 개수를 검증한다.
     * 
     * @param winningNumbers 당첨 번호
     * @throws IllegalArgumentException 6개가 아닌 경우
     */
    public static void checkNumberOfWinningNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() != COUNT_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LOTTO_NUMBER.getMessage());
        }
    }

    /**
     * 빈 당첨 번호가 입력되었는지 검증한다.
     *
     * @param winningNumbers 당첨 번호
     * @throws IllegalArgumentException 공백이 입력된 경우
     */
    public static void checkBlankOfWinningNumbers(List<String> winningNumbers) {
        if (winningNumbers.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(BLANK_LOTTO_NUMBER.getMessage());
        }
    }

    /**
     * 당첨 번호가 범위 내인지 확인한다.
     *
     * @param winningNumbers
     * @throws IllegalArgumentException 1 ~ 45번이 아닌 경우
     */
    public static void checkInRangeOfWinningNumbers(List<Integer> winningNumbers) {
        checkMinimum(winningNumbers);
        checkMaximum(winningNumbers);
    }

    private static void checkMinimum(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch((num) -> num < MINIMUM_OF_LOTTO_NUMBER.getDetails())) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage());
        }
    }

    private static void checkMaximum(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch((num) -> num > MAXIMUM_OF_LOTTO_NUMBER.getDetails())) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage());
        }
    }

    /**
     * 당첨 번호가 중복되었는지 검증한다.
     *
     * @param winningNumbers 당첨 번호
     * @throws IllegalArgumentException 중복된 경우
     */
    public static void checkDuplicateWinningNumbers(List<Integer> winningNumbers) {
        HashSet<Integer> uniquewinningNumbers = new HashSet<>(winningNumbers);
        if (uniquewinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
