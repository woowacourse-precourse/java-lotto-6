package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningChecker {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoWinningChecker(List<Integer> winningNumber, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getRank(Lotto lotto) {
        int matchCount = getMatchCount(lotto.getNumbers());
        boolean bonusMatch = isBonusMatch(lotto, matchCount);
        return LottoRank.of(matchCount, bonusMatch);
    }

    private int getMatchCount(List<Integer> numbers) {
        List<Integer> matchNumbers = new ArrayList<>(winningLotto.getNumbers());
        matchNumbers.retainAll(numbers);
        return matchNumbers.size();
    }

    private boolean isBonusMatch(Lotto lotto, int matchCount) {
        return matchCount == LottoRank.SECOND.getMatchCount() && lotto.getNumbers().contains(bonusNumber);
    }
}
