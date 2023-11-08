package lotto;

import java.util.ArrayList;
import java.util.List;

public class DrawResult {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public DrawResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Prize check(Lotto lotto) {
        int matchCount = 0;
        boolean isBonusNumberMatch = false;

        List<Integer> numbers = lotto.getImmutableSortedNumbers();
        for (int n : numbers) {
            if (winningNumbers.contains(n)) {
                matchCount++;
            }
        }

        if (lotto.getImmutableSortedNumbers().contains(bonusNumber)) {
            isBonusNumberMatch = true;
        }

        return determineRank(matchCount, isBonusNumberMatch);
    }

    private Prize determineRank(int matchCount, boolean isBonusNumberMatch) {
        if (matchCount == 6) {
            return Prize.FIRST;
        }
        if (matchCount == 5 && isBonusNumberMatch) {
            return Prize.SECOND;
        }
        if (matchCount == 5) {
            return Prize.THIRD;
        }
        if (matchCount == 4) {
            return Prize.FOURTH;
        }
        if (matchCount == 3) {
            return Prize.FIFTH;
        }
        return Prize.LOSE;
    }
}
