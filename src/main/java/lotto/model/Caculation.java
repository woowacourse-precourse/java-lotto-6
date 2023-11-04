package lotto.model;

import java.util.List;
import lotto.constants.Constants;
import lotto.view.OutputView;

public class Caculation {
    private double round = 10.0;
    private List<Integer> result;
    private int purchaseAmount;

    public Caculation(List<Integer> result, int purchaseAmount) {
        this.result = result;
        this.purchaseAmount = purchaseAmount;
    }

    public void displayStatistics() {
        double sumPrize = calculateSumPrize();
        double beforeRate = sumPrize / purchaseAmount * Constants.PERCENTAGE.getConstants();
        double rate = Math.round(beforeRate * round) / round;
        OutputView.printResult(result, rate);
    }

    private double calculateSumPrize() {
        double sumPrize = 0;
        sumPrize += Constants.SAME_3.getConstants() * result.get(0);
        sumPrize += Constants.SAME_4.getConstants() * result.get(1);
        sumPrize += Constants.SAME_5.getConstants() * result.get(2);
        sumPrize += Constants.SAME_5_BONUS.getConstants() * result.get(4);
        sumPrize += Constants.SAME_6.getConstants() * result.get(3);
        return sumPrize;
    }
}
