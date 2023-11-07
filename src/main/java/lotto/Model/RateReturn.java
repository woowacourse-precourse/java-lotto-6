package lotto.Model;

import static lotto.View.SystemMessage.getReward;

import java.util.Collections;
import java.util.List;

public class RateReturn {

    private final List<Integer> rewards = getReward();
    public static final int VALID_MATCH_NUMBERS = 5;
    public static final int ACTUAL_MATCH_NUMBER = 3;
    private final int ADJUST_RATE_RETURN = 10;

    private final double rateReturn;

    public RateReturn(List<Integer> countWins,int countLotto) {
        this.rateReturn = calculateRateReturn(countWins, countLotto);
    }

    private double calculateRateReturn(List<Integer> winsCount, int countLotto) {
        double result = 0;

        for (int i = 0; i < VALID_MATCH_NUMBERS; i++) {
            result += Collections.frequency(winsCount,i+ACTUAL_MATCH_NUMBER) * rewards.get(i);
        }
        result = result / (countLotto * ADJUST_RATE_RETURN);

        return result;
    }

    public double getRateReturn() {
        return rateReturn;
    }

}
