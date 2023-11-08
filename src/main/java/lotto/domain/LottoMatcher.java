package lotto.domain;

import lotto.constant.Rank;

public final class LottoMatcher {

    private final WinningNumbers winningNumbers;

    public LottoMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Rank match(Lotto lotto) {
        int matchedCount = countMatchedNumbers(lotto);
        boolean hasBonusMatch = hasMatchingBonusNumber(lotto);
        return Rank.findRank(matchedCount, hasBonusMatch);
    }

    private boolean hasMatchingBonusNumber(Lotto lotto) {
        return lotto.numbers().contains(winningNumbers.bonusNumber());
    }

    private int countMatchedNumbers(Lotto lotto) {
        return (int) winningNumbers.drawnNumbers().stream()
            .filter(lotto.numbers()::contains)
            .count();
    }
}
