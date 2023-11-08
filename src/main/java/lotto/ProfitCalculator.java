package lotto;

import static lotto.constant.Constants.BONUS_BALL;
import static lotto.enumerate.LottoPrize.MATCH_3;
import static lotto.enumerate.LottoPrize.MATCH_4;
import static lotto.enumerate.LottoPrize.MATCH_5;
import static lotto.enumerate.LottoPrize.MATCH_5_PLUS_BONUS;
import static lotto.enumerate.LottoPrize.MATCH_6;

import java.util.HashMap;
import java.util.Map;

public class ProfitCalculator {

    public double calculateProfit(int moneyInput, Map<Integer, Integer> winners) {
        int prize = 0;
        Map<Integer, Integer> prizeMap = new HashMap<>();
        prizeMap.put(3, MATCH_3.getPrize());
        prizeMap.put(4, MATCH_4.getPrize());
        prizeMap.put(5, MATCH_5.getPrize());
        prizeMap.put(5 + BONUS_BALL, MATCH_5_PLUS_BONUS.getPrize());
        prizeMap.put(6, MATCH_6.getPrize());

        for (Map.Entry<Integer, Integer> entry : winners.entrySet()) {
            int match = entry.getKey();
            int count = entry.getValue();
            prize += prizeMap.getOrDefault(match, 0) * count;
        }

        double profit = (double) prize / (double) moneyInput * 100;
        return profit;
    }
}
