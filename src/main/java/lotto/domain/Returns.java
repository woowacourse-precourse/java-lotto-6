package lotto.domain;


import java.util.Map;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.rule.PrizeAmount;

public class Returns {
    private String returns;
    private final Wallet wallet;
    private final WinRecord winRecord;

    public Returns(Wallet wallet, WinRecord winRecord) {
        this.wallet = wallet;
        this.winRecord = winRecord;
    }

    public void print() {
        OutputMessage.printf(MessageType.OUTPUT_RETURNS, this.returns);
    }

    public void calculate() {
        Map<Integer, PrizeAmount> prizeAmounts = PrizeAmount.getPrizeAmounts();
        double sumPrizeAmount = this.winRecord.sumPrizeAmount(prizeAmounts);
        double returnsPercentage = this.wallet.returnsPercent(sumPrizeAmount);
        this.returns = returnsPercentage + "%";
    }
}
