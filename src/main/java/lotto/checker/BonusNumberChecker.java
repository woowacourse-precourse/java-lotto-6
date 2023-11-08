package lotto.checker;

import static lotto.constant.ExceptionMessage.REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS;
import static lotto.constant.ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER;
import static lotto.constant.Number.LOTTO_MAX_NUM;
import static lotto.constant.Number.LOTTO_MIN_NUM;

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
        if (bonusNumber < LOTTO_MIN_NUM.getNumber() || bonusNumber > LOTTO_MAX_NUM.getNumber()) {
            OutputHandler.requireRightRangeNumber();
            throw new IllegalArgumentException(REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
        }
    }

    public void differentFrom(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            OutputHandler.requireDifferentNumberWithWinningNumbers();
            throw new IllegalArgumentException(REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
