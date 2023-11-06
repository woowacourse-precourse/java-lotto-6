package lotto.domain;

import lotto.enums.Ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoResult {
    private long totalPrize;
    private BigDecimal prizeRate;
    private Map<Ranking, Integer> rankingCounts;

    public LottoResult(Map<Ranking, Integer> rankingCount, int money) {
        this.rankingCounts = rankingCount;
        findTotalPrize();
        findPrizeRate(money);
    }

    private void findTotalPrize() {
        for (Ranking ranking : rankingCounts.keySet()) {
            totalPrize += (long) ranking.getPrize() * rankingCounts.get(ranking);
        }
    }

    private void findPrizeRate(int money) {
        BigDecimal prize = BigDecimal.valueOf(totalPrize);
        BigDecimal spent = BigDecimal.valueOf(money);
        prizeRate = prize.divide(spent, 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("당첨 통계").append(System.lineSeparator())
                .append("---").append(System.lineSeparator());

        Ranking[] values = Ranking.values();
        for (int i = 1; i < values.length; i++) {
            result.append(values[i].getResult()).append(rankingCounts.get(values[i])).append("개").append(System.lineSeparator());
        }

        result.append("총 수익률은 ").append(prizeRate.toPlainString()).append("%입니다.");

        return result.toString();
    }
}
