package lotto.model;

import lotto.model.enums.Rank;

import java.util.Collections;
import java.util.List;

public class LottoRankManager {
    private WinningLotto winningLotto;

    private LottoRankResult rankResult;

    public LottoRankManager(WinningLotto winningLotto, LottoRankResult rankResult) {
        this.winningLotto = winningLotto;
        this.rankResult = rankResult;
    }

    public void compareLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchingNumbers = countMatchingNumbers(lotto);
            boolean bonusMatch = isBonusMatch(lotto);
            int rank = getRankByMatchData(matchingNumbers, bonusMatch);
            increaseRank(rank);
        }
    }

    public int countMatchingNumbers(Lotto lotto) {
        int count = 0;
        for (int singleNumber : winningLotto.getNumbers()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            count += Collections.frequency(lottoNumbers, singleNumber);
        }
        return count;
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.contains(winningLotto.getBonus());
    }

    private int getRankByMatchData(int matchingNumber, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.isMatch(matchingNumber, bonusMatch)) {
                return rank.getRank();
            }
        }
        return Rank.NO_RANK.getRank();
    }

    private void increaseRank(int rank) {
        rankResult.increaseRankCount(rank);
    }
}
