package lotto.domain;


import java.util.List;
import java.util.Map;
import lotto.domain.rule.PrizeAmount;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class Returns {
    private final List<Integer> winRecord;
    private String returns;

    public Returns(int wallet, List<Integer> winRecord) {
        this.winRecord = winRecord;
    }

    public void print() {
        calculate();
        OutputMessage.printf(MessageType.OUTPUT_RETURNS, this.returns);
    }

    private void calculate() {
        Map<Integer, PrizeAmount> prizeAmounts = PrizeAmount.getPrizeAmounts();
        double value = 0.0;

        for (Integer integer : this.winRecord) {
            PrizeAmount prizeAmount = prizeAmounts.get(integer);

            if(prizeAmount != null){
                value += prizeAmount.getAmount();
            }
        }
        double result = Math.round(value * 100) / 100.0;

        this.returns = result + "%";
    }
}
