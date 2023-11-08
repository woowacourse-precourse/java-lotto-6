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
        long matchCount = getMatchCount(lotto);
        boolean hasBonusNumber = hasBonusNumber(lotto);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchesCondition(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(Rank.MISS);
    }

    private long getMatchCount(Lotto lotto) {
        return winningNumbers.matchCount(lotto);
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber.number());
    }
}
