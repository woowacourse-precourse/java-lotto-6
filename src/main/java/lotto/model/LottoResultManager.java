package lotto.model;

import lotto.model.enums.RankPrize;

import java.util.Collections;
import java.util.List;

public class LottoResultManager {
    private WinningLotto winningLotto;
    private LottoRankResult rankResult;
    private LottoPrizeResult prizeResult;

    public LottoResultManager(WinningLotto winningLotto, LottoRankResult rankResult, LottoPrizeResult prizeResult) {
        this.rankResult = rankResult;
        this.winningLotto = winningLotto;
        this.prizeResult = prizeResult;
    }

    public void generateResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchingNumbers = countMatchingNumbers(lotto);
            boolean bonusMatch = isBonusMatch(lotto);
            RankPrize rankPrize = getPrizeByMatchData(matchingNumbers, bonusMatch);
            rankResult.increaseRankCount(rankPrize.getRank());
            prizeResult.addTotalPrize(rankPrize.getPrize());
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

    private RankPrize getPrizeByMatchData(int matchingNumber, boolean bonusMatch) {
        for (RankPrize rankPrize : RankPrize.values()) {
            if (rankPrize.isMatch(matchingNumber, bonusMatch)) {
                return rankPrize;
            }
        }
        return RankPrize.NO_RANK;
    }

    public LottoRankResult getRankResult() {
        return rankResult;
    }

    public double getRateOfReturn(int purchaseMoney) {
        long totalPrize = prizeResult.getTotalPrize();
        return (double) totalPrize / purchaseMoney * 100;
    }
}
