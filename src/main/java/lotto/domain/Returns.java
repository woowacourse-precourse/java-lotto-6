package lotto.domain;


import java.util.Map;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.constant.PrizeAmount;

public class Returns {
    private String returns;
    private final int money;

    public Returns(int money) {
        this.money = money;
    }

    public void print() {
        OutputMessage.printf(MessageType.OUTPUT_RETURNS, this.returns);
    }

    public void calculate(WinRecord winRecord) {
        double sumPrizeAmount = sumPrizeAmount(winRecord);
        double returnsPercentage = returnsPercent(sumPrizeAmount);
        this.returns = returnsPercentage + "%";
    }

    private double returnsPercent(double sumPrizeAmount) {
        return Math.round((sumPrizeAmount / this.money) * 1000) / 10.0;
    }

    private double sumPrizeAmount(WinRecord winRecord) {
        Map<Integer, PrizeAmount> prizeAmounts = PrizeAmount.getPrizeAmounts();

        double prizeAmount = winRecord.get().stream()
                .filter(prizeAmounts::containsKey)
                .map(prizeAmounts::get)
                .mapToDouble(PrizeAmount::getAmount)
                .sum();

        return prizeAmount;
    }
}
