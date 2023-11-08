package lotto.checker;

import static lotto.constant.ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER;
import static lotto.constant.ExceptionMessage.REQUIRE_SIX_NUMBERS;
import static lotto.constant.ExceptionMessage.REQUIRE_UNIQUE_NUMBERS;

import java.util.HashSet;
import java.util.List;
import lotto.constant.Number;
import lotto.view.OutputHandler;

public class WinningNumbersChecker {

    static HashSet<Integer> uniqueWinningNumbers = new HashSet<>();

    public static void rightSize(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != Number.LOTTO_NUM_COUNT.getNumber()) {
            OutputHandler.requireSixNumbers();
            throw new IllegalArgumentException(REQUIRE_SIX_NUMBERS.getMessage());
        }
    }

    public static void rightNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        uniqueWinningNumbers = new HashSet<>();
        for (Integer winningNumber : winningNumbers) {
            isRightRange(winningNumber);
            isUnique(winningNumber);
        }
    }

    private static void isRightRange(int winningNumber) throws IllegalArgumentException {
        if (winningNumber < Number.LOTTO_MIN_NUM.getNumber()
                || winningNumber > Number.LOTTO_MAX_NUM.getNumber()) {
            OutputHandler.requireRightRangeNumber();
            throw new IllegalArgumentException(REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
        }
    }

    private static void isUnique(int winningNumber) throws IllegalArgumentException {
        if (uniqueWinningNumbers.contains(winningNumber)) {
            OutputHandler.requireUniqueNumbers();
            throw new IllegalArgumentException(REQUIRE_UNIQUE_NUMBERS.getMessage());
        }
        uniqueWinningNumbers.add(winningNumber);
    }
}
