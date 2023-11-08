package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLottoNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank matchingNumbers(Lotto lotto) {
        int count = getMatchingCount(lotto);
        boolean bonus = lotto.hasNumber(bonusNumber);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchRank(count, bonus)&&rank.getPrize()!=0)
                .findFirst()
                .orElse(Rank.NOTHING_ZERO);
    }

    private int getMatchingCount(Lotto lotto) {
        return (int) winningLottoNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }
}
