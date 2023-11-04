package lotto.service;

import static lotto.constant.LottoResult.*;
import lotto.domain.LottoResultCount;
import lotto.view.OutputView;

public class ResultService {
    private LottoResultCount lottoResultCount;
    private OutputView outputView = new OutputView();
    private int amount;

    public ResultService(LottoResultCount lottoResultCount, int amount) {
        this.lottoResultCount = lottoResultCount;
        this.amount = amount;
        lottoResult();
    }

    public void lottoResult() {
        outputView.outputWinningResult(lottoResultCount,lottoProfitRate());
    }

    private Double lottoProfitRate(){
        long total = totalWinningProfit();
        return calculateRate(total, amount);
    }

    private long totalWinningProfit(){
        return (long) lottoResultCount.getThreeCount() * THREE_COUNT.getPrizeMoney()
                + (long)lottoResultCount.getFourCount() * FOUR_COUNT.getPrizeMoney()
                + (long) lottoResultCount.getFiveCount() * FIVE_COUNT.getPrizeMoney()
                + (long) lottoResultCount.getFiveWithBonusCount() * FIVE_COUNT_WITH_BONUS.getPrizeMoney()
                + (long) lottoResultCount.getSixCount() * SIX_COUNT.getPrizeMoney();
    }

    private double calculateRate(long totalMoney, int amount) {
        if (amount == 0) {
            return 0.0;
        }
        double rate = (double) totalMoney / amount;
        return Math.round(rate * 100.0) / 100.0;
    }
}
