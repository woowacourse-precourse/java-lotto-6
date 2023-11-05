package lotto.domain;

import java.util.List;

import static lotto.domain.Constants.*;

public class WinningNumbers {

    List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void validateDuplication(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUM_DUPLICATE_MESSAGE);
        }
    }

    public int countMatchedNumber(Lotto lotto) {
        return (int) lotto.getNumbers().stream().filter(winningNumbers::contains).distinct().count();
    }
}
