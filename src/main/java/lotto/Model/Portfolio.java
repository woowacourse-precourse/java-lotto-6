package lotto.Model;

import static lotto.Constants.TurnOuts.TURN_OUT_RATE;

import java.util.Map;
import lotto.Constants.MatchTypes;

public class Portfolio {
    public Double calculateTurnOut(Map<MatchTypes, Integer> gameResult, Integer lotteryBudget) {
        Integer totalPrize = MatchTypes.calculateTotalPrize(gameResult);
        return TURN_OUT_RATE.calculate(totalPrize, lotteryBudget);
    }
}
