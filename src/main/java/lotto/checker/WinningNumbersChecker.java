package lotto.checker;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.Number;
import lotto.view.OutputHandler;

public class WinningNumbersChecker {

    List<Integer> winningNumbers;
    HashSet<Integer> uniqueWinningNumbers = new HashSet<>();

    public WinningNumbersChecker(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void rightSize() throws IllegalArgumentException {
        if (winningNumbers.size() != Number.LOTTO_NUM_COUNT.getNumber()) {
            OutputHandler.requireSixNumbers();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_SIX_NUMBERS.getMessage());
        }
    }

    public void rightNumbers() throws IllegalArgumentException {
        for (Integer winningNumber : winningNumbers) {
            isRightRange(winningNumber);
            isUnique(winningNumber);
        }
    }

    private void isRightRange(int winningNumber) throws IllegalArgumentException {
        if (winningNumber < Number.LOTTO_MIN_NUM.getNumber()
                || winningNumber > Number.LOTTO_MAX_NUM.getNumber()) {
            OutputHandler.requireRightRangeNumber();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
        }
    }

    private void isUnique(int winningNumber) throws IllegalArgumentException {
        if (uniqueWinningNumbers.contains(winningNumber)) {
            OutputHandler.requireUniqueNumbers();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_UNIQUE_NUMBERS.getMessage());
        }
        uniqueWinningNumbers.add(winningNumber);
    }
}
