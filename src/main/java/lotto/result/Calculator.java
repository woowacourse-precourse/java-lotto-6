package lotto.result;

import java.util.Map;
import lotto.util.message.OutputMessage;

import static lotto.util.Constant.DEFAULT_VALUE;
import static lotto.util.Constant.PERCENT_BASE;
import static lotto.util.Constant.RATE;

public class Calculator {

    public void getProfitRate(Map<Grade, Integer> resultMap, int purchasedPrice) {
        double profitRate = calculateProfitRate(resultMap, purchasedPrice);
        OutputMessage.profitRate(profitRate);
    }

    public double calculateProfitRate(Map<Grade, Integer> resultMap, int purchasedPrice) {
        long sum = 0;
        for (Grade grade : Grade.values()) {
            sum += grade.getPrice() * resultMap.getOrDefault(grade, DEFAULT_VALUE);
        }

        double profitRate = sum * PERCENT_BASE / purchasedPrice;
        return Math.round(profitRate * RATE) / RATE;
    }
}
