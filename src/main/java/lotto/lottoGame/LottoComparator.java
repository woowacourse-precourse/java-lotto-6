package lotto.lottoGame;

import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;
import lotto.lottoGame.rank.MatchValue;
import lotto.lottoGame.rank.Rank;

public class LottoComparator {

    public Rank calculateLottoRank(WinningLotto winningLotto, Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
        List<Integer> customerNumbers = lotto.getNumbers();
        Integer bonusNumber = winningLotto.getBonusNumber();

        MatchValue matchValue = new MatchValue();
        for (Integer number : customerNumbers) {
            matchWinningNumber(matchValue, winningNumbers, number);
            matchWinningBonusNumber(matchValue, bonusNumber, number);
        }

        return findRank(matchValue);
    }

    private Rank findRank(MatchValue matchValue) {
        int matchCount = matchValue.getMatchCounts();
        boolean matchBonus = matchValue.isBonusMatch();

        return Rank.getRankByMatchData(matchCount, matchBonus);
    }

    private void matchWinningBonusNumber(MatchValue matchValue, Integer winningNumbers, Integer number) {
        if (winningNumbers.equals(number)) {
            matchValue.matchBonusNumber();
        }
    }

    private void matchWinningNumber(MatchValue matchValue, List<Integer> winningNumbers, Integer customerNumber) {
        if (winningNumbers.contains(customerNumber)) {
            matchValue.addMatchCount();
        }
    }
}
