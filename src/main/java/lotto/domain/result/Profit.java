package lotto.domain.result;

import static lotto.utils.LottoConstant.PROFIT_MULTIPLY;
import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;

import lotto.service.LottoMessagePrinter;

public class Profit {

    private double percentage;

    public static Profit of() {
        return new Profit();
    }

    public void apply(WinningMoney winningMoney, int purchaseCount) {
        this.percentage =
                (winningMoney.getMoney().doubleValue() / (purchaseCount * PURCHASE_AMOUNT_UNIT)) * PROFIT_MULTIPLY;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public void print(LottoMessagePrinter writer) {
        writer.printProfit(this.percentage);
    }
}
