package lotto.validator;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.DUPLICATED_NUMBER;
import static lotto.constants.ExceptionMessages.DUPLICATED_WITH_WINNING_NUM;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_RANGE;
import static lotto.constants.ExceptionMessages.INVALID_TOTAL_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumValidator {

    private static final String SEPARATOR = ",";
    private static final int TOTAL_NUM = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    public static void validateWinningNums(String winNums) {
        checkNull(winNums);
        List<Integer> numbers = split(winNums);
        checkDuplicated(numbers);
        checkTotalNum(numbers);
        numbers.forEach(num -> checkRange(num));
    }

    private static void checkRange(int num) {
        if (num < MIN_NUM || num > MAX_NUM) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_RANGE);
        }
    }

    private static void checkTotalNum(List<Integer> numbers) {
        if (numbers.size() != TOTAL_NUM) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_TOTAL_NUMBER);
        }
    }

    private static void checkDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(CATCH_ERROR + DUPLICATED_NUMBER);
        }
    }

    private static void checkNull(String winNums) {
        if (winNums == null || winNums.isEmpty()) {
            throw new IllegalArgumentException(CATCH_ERROR + INPUT_EMPTY);
        }
    }

    private static List<Integer> split(String winNums) {
        List<String> numbers = Arrays.asList(winNums.split(SEPARATOR));
        return numbers.stream().map(WinningNumValidator::toInteger).collect(Collectors.toList());
    }

    private static Integer toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CATCH_ERROR + INVALID_NUMBER);
        }
    }

    public static void validateBonus(String bonus, String winningNums) {
        checkNull(bonus);
        int bonusNum = toInteger(bonus);
        checkRange(bonusNum);
        checkOverlappingWithWinningNums(split(winningNums), bonusNum);
    }

    private static void checkOverlappingWithWinningNums(List<Integer> winningNums, int bonusNum) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException(CATCH_ERROR + DUPLICATED_WITH_WINNING_NUM);
        }
    }
}
