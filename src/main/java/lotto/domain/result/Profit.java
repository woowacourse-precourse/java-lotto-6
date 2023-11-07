package lotto.domain.result;

import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;

import lotto.io.write.OutputWriter;

public class Profit {

    private final double percentage;

    public Profit(WinningMoney winningMoney, int purchaseCount) {
        this.percentage = winningMoney.getMoney().doubleValue() / (purchaseCount * PURCHASE_AMOUNT_UNIT);
    }

    public double getPercentage() {
        return percentage;
    }

    public void print() {
        OutputWriter.showProfit(this.percentage);
    }
}
