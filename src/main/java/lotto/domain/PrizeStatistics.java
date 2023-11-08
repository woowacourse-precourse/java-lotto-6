package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrizeStatistics {

    private final Map<Prize, Integer> prizeStatistics;

    public PrizeStatistics() {
        this.prizeStatistics = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeStatistics.put(prize, 0));
    }

    public void updatePrizeStatistics(Prize prize) {
        prizeStatistics.merge(prize, 1, Integer::sum);
    }

    public int getCountForPrize(Prize prize) {
        return prizeStatistics.get(prize);
    }

    public Long calculateWinningAmount() {
        long winningAmount = 0;
        for (Prize prize : prizeStatistics.keySet()) {
            winningAmount += (long) prize.getPrizeMoney() * getCountForPrize(prize);
        }

        return winningAmount;
    }

    public Double calculateLottoRateOfReturn(Price price) {
        int purchaseAmount = price.getPrice();
        long winningAmount = calculateWinningAmount();

        double rateOfreturn = (double) winningAmount / purchaseAmount * 100;
        rateOfreturn = Math.round(rateOfreturn * 100.0) / 100.0; // 소수 둘째자리에서 반올림

        return rateOfreturn;
    }

}
