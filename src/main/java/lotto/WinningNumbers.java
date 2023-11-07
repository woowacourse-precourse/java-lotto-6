package lotto;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.ErrorMessage.*;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.getMessage());
        }
        else if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE.getMessage());
        }
        else if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE.getMessage());
        }
    }

    public int getRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingNumbers = (int) lottoNumbers.stream().filter(numbers::contains).count();
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

        if (matchingNumbers == 6) {
            return 1;
        } else if (matchingNumbers == 5 && hasBonusNumber) {
            return 2;
        } else if (matchingNumbers == 5) {
            return 3;
        } else if (matchingNumbers == 4) {
            return 4;
        } else if (matchingNumbers == 3) {
            return 5;
        }

        return 0;
    }
}
