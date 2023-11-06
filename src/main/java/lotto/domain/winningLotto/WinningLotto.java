package lotto.domain.winningLotto;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class WinningLotto {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank determineRank(Lotto lotto) {
        long matchCount = winningNumbers.matchCount(lotto);
        boolean hasBonusNumber = lotto.contains(bonusNumber.number());
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchesCondition(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(Rank.MISS);
    }
}
