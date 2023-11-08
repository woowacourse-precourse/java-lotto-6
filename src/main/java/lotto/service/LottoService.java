package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoRank;
import lotto.domain.Lottos;

public class LottoService {
    private final TotalPrize totalPrize;

    public LottoService() {
        this.totalPrize = new TotalPrize();
    }

    public void gradingLottos(Lottos lottos, Lotto winningLotto, int bonus) {
        for (Lotto userLotto : lottos.getLottos()) {
            int matchedNumber = userLotto.getMatchedNumber(winningLotto);
            if (matchedNumber < LottoRank.FIFTH.count()) continue;
            if (matchedNumber == LottoRank.FIRST.count()) {
                totalPrize.increasePrize(LottoRank.FIRST);
                continue;
            }
            if (matchedNumber == LottoRank.FOURTH.count()) {
                totalPrize.increasePrize(LottoRank.FOURTH);
                continue;
            }
            if (matchedNumber == LottoRank.FIFTH.count()) {
                totalPrize.increasePrize(LottoRank.FIFTH);
                continue;
            }
            int unmatchedNumber = userLotto.getUnmatchedNumber(winningLotto);
            if (unmatchedNumber == bonus) {
                totalPrize.increasePrize(LottoRank.SECOND);
                continue;
            }
            totalPrize.increasePrize(LottoRank.THIRD);
        }
    }

    public String showLottoResult(long money) {
        StringBuilder sb = new StringBuilder();
        for (LottoRank rank : LottoRank.values()) {
            int count = totalPrize.getPrizeCount(rank);
            sb.append(rank.message() + String.format("%d", count) + "개\n");
        }
        double rate = calculreateRateOfReturn(money);
        sb.append("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
        return sb.toString();
    }

    private double calculreateRateOfReturn(long money) {
        long prize = totalPrize.sumTotalPrizeAmount();
        return prize / (double) money * 100;
    }
}
