package lotto.model;

import java.util.List;
import lotto.exception.LottoException;

public class ResultLotto {

    private final Lotto winningLotto;
    private final List<Integer> winningNumbers;
    private final int bonusNum;

    public ResultLotto(List<Integer> numbers, int bonusNum) {
        this.winningLotto = new Lotto(numbers);
        this.winningNumbers = numbers;
        validateRange(bonusNum);
        validateDuplicate(bonusNum);
        this.bonusNum = bonusNum;
    }

    private int matchLotto(Lotto lotto) {
        int matchCount = 0;
        for (int number : winningNumbers) {
            if (lotto.isContainNum(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void validateRange(int bonusNum) {
        if (bonusNum < 0 || bonusNum > 45) {
            throw new IllegalArgumentException(LottoException.INVALID_RANGE.getExceptionMessage());
        }
    }

    private void validateDuplicate(int bonusNum) {
        if (winningLotto.isContainNum(bonusNum)) {
            throw new IllegalArgumentException(LottoException.NOT_DUPLICATE.getExceptionMessage());
        }
    }
}
