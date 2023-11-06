package lotto.service;

import lotto.view.LottoOutputView;
import lotto.view.View;

public class CalculateProfitService implements Service {
    private final LottoOutputView lottoOutputView;
    CalculateProfitService(View lottoOutputView) {
        this.lottoOutputView = (LottoOutputView) lottoOutputView;
    }

    public void calculateProfit(Integer money, Long totalReward) {
        Double profitRate = getProfitRate(money, totalReward);
        lottoOutputView.printProfitRate(profitRate);
    }

    private Double getProfitRate(Integer money, Long totalReward) {
        return ((double) totalReward * 100) / money;
    }
}
