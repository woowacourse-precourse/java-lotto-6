package lotto.Constants;

import java.util.function.BiFunction;

public enum TurnOuts {
    TURN_OUT_RATE("\n총 수익률은 %.1f%%입니다.", (Integer totalPrize, Integer lotteryBudget) -> {
        return (totalPrize / (double) lotteryBudget) * 100;
    });

    private String message;
    private BiFunction<Integer, Integer, Double> calculator;

    TurnOuts(String message, BiFunction<Integer, Integer, Double> calculator) {
        this.message = message;
        this.calculator = calculator;
    }

    public String getMessage() {
        return message;
    }

    public Double calculate(Integer totalPrize, Integer lotteryBudget) {
        return calculator.apply(totalPrize, lotteryBudget);
    }
}
