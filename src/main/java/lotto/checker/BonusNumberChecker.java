package lotto.checker;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.Number;
import lotto.view.OutputHandler;

public class BonusNumberChecker {

    private int bonusNumber;

    public BonusNumberChecker(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void rightRange() throws IllegalArgumentException {
        if (bonusNumber < Number.LOTTO_MIN_NUM.getNumber()
                || bonusNumber > Number.LOTTO_MAX_NUM.getNumber()) {
            OutputHandler.requireRightRangeNumber();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
        }
    }

    public void differentFrom(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            OutputHandler.requireDifferentNumberWithWinningNumbers();
            throw new IllegalArgumentException(
                    ExceptionMessage.REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
