package lotto.domain;

import static lotto.constant.ExceptionMessages.NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.domain.Lotto.isNumberInRange;
import static lotto.domain.Lotto.throwDuplicateException;

public class WinningNumber {

    private final Lotto winningNumber;
    private final int bonusNumber;

    private WinningNumber(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber validate(Lotto lotto, int bonusNumber) {
        validateDuplication(lotto, bonusNumber);
        validateNumberRange(bonusNumber);
        return new WinningNumber(lotto, bonusNumber);
    }

    private static void validateDuplication(Lotto lotto, int bonusNumber) {
        if (lotto.containNumber(bonusNumber)) {
           throwDuplicateException();
        }
    }

    private static void validateNumberRange(int number) {
        if (isNumberInRange(number)) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
