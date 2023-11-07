package lotto.model;

import java.util.ArrayList;
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

    private List<Integer> matchLottoBundle(List<Lotto> lottoBundle) {
        List<Integer> winningCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        int ranking;
        for (Lotto lotto : lottoBundle) {
            ranking = matchLotto(lotto);
            if (ranking < 0) {
                continue;
            }
            winningCount.set(ranking, winningCount.get(ranking) + 1);
        }
        return winningCount;
    }

    private int matchLotto(Lotto lotto) {
        int matchCount = 0;
        for (int number : winningNumbers) {
            if (lotto.isContainNum(number)) {
                matchCount++;
            }
        }
        return matchRanking(matchCount, lotto);
    }

    private int matchRanking(int matchCount, Lotto lotto) {
        if (matchCount == 6) {
            return 0;
        }
        if (matchCount == 5 && lotto.isContainNum(bonusNum)) {
            return 1;
        }
        if (matchCount <= 5 && matchCount >= 3) {
            return 7 - matchCount;
        }
        return -1;
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
