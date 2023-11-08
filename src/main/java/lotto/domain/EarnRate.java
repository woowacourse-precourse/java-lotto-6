package lotto.domain;

import lotto.constants.PrizeEnum;
import lotto.io.OutputHandler;

import java.util.HashMap;

public class EarnRate {

    double EarnRate;
    int inputAmount;
    int totalEarning;
    HashMap<String, Integer> drawResult;
    public EarnRate(int inputAmount, HashMap<String, Integer> drawResult) {
        this.EarnRate = 1;
        this.inputAmount = inputAmount;
        this.totalEarning = 0;
        this.drawResult = drawResult;
        sumTotalEarning();
    }

    private void sumTotalEarning() {
        if (drawResult == null) {
            throw new NullPointerException();
        }
        drawResult.forEach((key, value) -> {
            totalEarning += PrizeEnum.valueOf(key).getAmount() * value;
        });
    }

    private double getEarnRate(){
        if (inputAmount == 0) {
            throw new ArithmeticException("");
        }
        return (double) totalEarning / (double) inputAmount;
    }

    public void printEarnRate(){
        OutputHandler.printReturnRate(this.getEarnRate());
    }
}
