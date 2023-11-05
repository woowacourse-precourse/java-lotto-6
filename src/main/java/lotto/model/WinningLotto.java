package lotto.model;

import static lotto.exception.ExceptionMessage.INVALID_DUPLICATE_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_RANGE_OF_BONUS_NUMBER;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumber, int bonusNumber) {
        super(winningLottoNumber);
        validateBonusNumber(bonusNumber);
        validateBonusNumberNotInLottoNumbers(bonusNumber, winningLottoNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_BONUS_NUMBER.getErrorMessage());
        }
    }

    private void validateBonusNumberNotInLottoNumbers(int bonusNumber, List<Integer> winningLottoNumber) {
        if (winningLottoNumber.stream().anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public int calculateMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(this.getNumbers()::contains)
                .count();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
