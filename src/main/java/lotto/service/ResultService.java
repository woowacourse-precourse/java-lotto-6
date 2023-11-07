package lotto.service;

import static lotto.constant.LottoResult.*;
import lotto.domain.LottoResultCount;

public class ResultService {

    private LottoResultCount lottoResultCount;
    private int amount;

    public void createResultService(LottoResultCount lottoResultCount, int amount) {
        this.lottoResultCount = lottoResultCount;
        this.amount = amount;
    }

    public LottoResultCount getLottoResultCount() {
        return this.lottoResultCount;
    }


    public Double getLottoProfitRate(){
        long total = totalWinningProfit();
        return calculateRate(total, amount);
    }

    private long totalWinningProfit(){
        return (long) this.lottoResultCount.getThreeCount() * THREE_COUNT.getPrizeMoney()
                + (long) this.lottoResultCount.getFourCount() * FOUR_COUNT.getPrizeMoney()
                + (long) this.lottoResultCount.getFiveCount() * FIVE_COUNT.getPrizeMoney()
                + (long) this.lottoResultCount.getFiveWithBonusCount() * FIVE_COUNT_WITH_BONUS.getPrizeMoney()
                + (long) this.lottoResultCount.getSixCount() * SIX_COUNT.getPrizeMoney();
    }

    private double calculateRate(long totalMoney, int amount) {
        if (amount == 0) {
            return 0.0;
        }
        double rate = (double) totalMoney / amount;
        return Math.round(rate * 100.0) / 100.0;
    }
}
