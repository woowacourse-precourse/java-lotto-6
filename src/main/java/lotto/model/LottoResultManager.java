package lotto.model;

import lotto.model.enums.PrizeInfo;

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
            PrizeInfo prizeInfo = getPrizeByMatchData(matchingNumbers, bonusMatch);
            rankResult.increaseRankCount(prizeInfo.getRank());
            prizeResult.addTotalPrize(prizeInfo.getPrize());
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

    private PrizeInfo getPrizeByMatchData(int matchingNumber, boolean bonusMatch) {
        for (PrizeInfo prizeInfo : PrizeInfo.values()) {
            if (prizeInfo.isMatch(matchingNumber, bonusMatch)) {
                return prizeInfo;
            }
        }
        return PrizeInfo.NO_PRIZE;
    }

    public LottoRankResult getRankResult() {
        return rankResult;
    }

    public double getRateOfReturn(int purchaseMoney) {
        long totalPrize = prizeResult.getTotalPrize();
        return (double) totalPrize / purchaseMoney * 100;
    }
}
