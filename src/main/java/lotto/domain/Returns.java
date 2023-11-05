package lotto.domain;


import java.util.List;
import java.util.Map;
import lotto.domain.rule.PrizeAmount;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class Returns {
    private final int wallet;
    private final List<Integer> winRecord;
    private String returns;

    public Returns(int wallet, List<Integer> winRecord) {
        this.wallet = wallet;
        this.winRecord = winRecord;
    }

    public void print() {
        OutputMessage.printf(MessageType.OUTPUT_RETURNS, this.returns);
    }

    public void calculate() {
        Map<Integer, PrizeAmount> prizeAmounts = PrizeAmount.getPrizeAmounts();
        double totalPrizeAmount = this.winRecord.stream()
                .filter(prizeAmounts::containsKey)
                .map(prizeAmounts::get)
                .mapToDouble(PrizeAmount::getAmount)
                .sum();

        double returnsPercentage = Math.round((totalPrizeAmount / this.wallet) * 1000) / 10.0;
        this.returns = returnsPercentage + "%";
    }
}
