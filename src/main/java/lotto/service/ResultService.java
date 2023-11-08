package lotto.service;

import static lotto.constant.LottoNumber.PURCHASE_AMOUNT_COND;
import static lotto.constant.LottoResult.*;

import lotto.domain.LottoResultCount;

public class ResultService {

    private LottoResultCount lottoResultCount;
    private int amount;
    private static final double percentageRate = 100.0;

    public void createResultService(LottoResultCount lottoResultCount, int amount) {
        this.lottoResultCount = lottoResultCount;
        this.amount = amount * PURCHASE_AMOUNT_COND.getNumber();
    }

    public LottoResultCount getLottoResultCount() {
        return this.lottoResultCount;
    }


    public Double getLottoProfitRate() {
        long total = totalWinningProfit();
        return calculateRate(total, amount);
    }

    private long totalWinningProfit() {
        return (long) this.lottoResultCount.getThreeCount() * THREE_COUNT.getPrizeMoney()
                + (long) this.lottoResultCount.getFourCount() * FOUR_COUNT.getPrizeMoney()
                + (long) this.lottoResultCount.getFiveCount() * FIVE_COUNT.getPrizeMoney()
                + (long) this.lottoResultCount.getFiveWithBonusCount() * FIVE_COUNT_WITH_BONUS.getPrizeMoney()
                + (long) this.lottoResultCount.getSixCount() * SIX_COUNT.getPrizeMoney();
    }

    private double calculateRate(long totalProfit, int amount) {
        if (amount == 0) {
            return 0.0;
        }
        double profitRate = (double) totalProfit / amount * percentageRate;
        return Math.round(profitRate * percentageRate) / percentageRate;
    }
}
