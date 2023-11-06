package lotto.domain;

import java.util.Map;
import java.util.StringJoiner;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.utils.LottoConstant;
import lotto.utils.Prize;

public class PrizeReception {
    private final Map<Prize, Integer> prizeCounts;

    public PrizeReception(Map<Prize, Integer> prizeCounts) {
        this.prizeCounts = prizeCounts;
    }

    public int getPrizeCount(Prize prize) {
        return prizeCounts.get(prize);
    }

    public double getProfitRate(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculateProfitRate(getAllPrizeProfit());
    }

    private long getAllPrizeProfit() {
        long allPrizeProfit = 0;
        for (Prize prize : prizeCounts.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * prizeCounts.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }

    // LottoManager 테스트 코드를 위한 메서드
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(LottoConstant.DELIMITER.get());
        stringJoiner.add(String.valueOf(prizeCounts.get(Prize.FIRST)));
        stringJoiner.add(String.valueOf(prizeCounts.get(Prize.SECOND)));
        stringJoiner.add(String.valueOf(prizeCounts.get(Prize.THIRD)));
        stringJoiner.add(String.valueOf(prizeCounts.get(Prize.FOURTH)));
        stringJoiner.add(String.valueOf(prizeCounts.get(Prize.FIFTH)));
        return stringJoiner.toString();
    }
}
