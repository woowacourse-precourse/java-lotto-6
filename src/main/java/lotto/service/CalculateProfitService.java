package lotto.service;

import static lotto.util.constants.Numbers.PERCENTAGE;

import lotto.view.LottoOutputView;

public class CalculateProfitService implements Service {
    CalculateProfitService() {
    }

    public void calculateProfit(final Integer money, final Long totalReward, final LottoOutputView outputView) {
        Double profitRate = getProfitRate(money, totalReward);
        outputView.printProfitRate(profitRate);
    }

    private Double getProfitRate(final Integer money, final Long totalReward) {
        return ((double) totalReward * PERCENTAGE.getNumber()) / money;
    }
}
