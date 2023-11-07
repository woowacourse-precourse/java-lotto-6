package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.Constant.MAX_NUMBER_SIZE;
import static lotto.ErrorMessage.*;
import static lotto.RankType.*;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;

        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
        }
        else if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
        }
        else if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE.getMessage());
        }
    }

    public int getRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingNumbers = (int) lottoNumbers.stream().
                filter(numbers::contains)
                .count();
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

        if (matchingNumbers == FIRST.getMatch()) {
            return 1;
        } else if (matchingNumbers == SECOND.getMatch() && hasBonusNumber) {
            return 2;
        } else if (matchingNumbers == THIRD.getMatch()) {
            return 3;
        } else if (matchingNumbers == FOURTH.getMatch()) {
            return 4;
        } else if (matchingNumbers == FIFTH.getMatch()) {
            return 5;
        }

        return 0;
    }
}
