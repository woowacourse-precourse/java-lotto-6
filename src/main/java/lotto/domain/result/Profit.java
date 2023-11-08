package lotto.domain.result;

import static lotto.utils.LottoConstant.PROFIT_MULTIPLY;
import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;

import lotto.service.LottoOutputWriter;

public class Profit {

    private final double percentage;

    public static Profit of(WinningMoney winningMoney, int size) {
        return new Profit(winningMoney, size);
    }

    private Profit(WinningMoney winningMoney, int purchaseCount) {
        this.percentage =
                (winningMoney.getMoney().doubleValue() / (purchaseCount * PURCHASE_AMOUNT_UNIT * PROFIT_MULTIPLY));
    }

    public double getPercentage() {
        return percentage;
    }

    public void print(LottoOutputWriter writer) {
        writer.showProfit(this.percentage);
    }
}
