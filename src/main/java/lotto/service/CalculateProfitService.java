package lotto.service;

import static lotto.util.constants.Numbers.PERCENTAGE;

import lotto.view.LottoOutputView;

public class CalculateProfitService implements Service {
    CalculateProfitService() {
    }

    /**
     * 수익률을 계산하고, 메시지로 출력하는 메서드.
     *
     * @param money 구입 금액(Integer)
     * @param totalReward 총 당첨 금액(Long)
     * @param outputView 출력 담당 객체(LottoOutputView)
     */
    public void calculateProfit(final Integer money, final Long totalReward, final LottoOutputView outputView) {
        Double profitRate = getProfitRate(money, totalReward);
        outputView.printProfitRate(profitRate);
    }

    private Double getProfitRate(final Integer money, final Long totalReward) {
        return ((double) totalReward * PERCENTAGE.getNumber()) / money;
    }
}
