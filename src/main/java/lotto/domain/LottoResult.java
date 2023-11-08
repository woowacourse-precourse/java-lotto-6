package lotto.domain;

import common.enumtype.ResultType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public static final int INIT_BOARD_COUNT = 0;
    public static final int INCREASE_COUNT = 1;
    public static final double DECIMAL_PLACE = 10.0;
    public static final int PERCENTAGE = 100;

    private final Map<ResultType, Integer> board;

    public LottoResult(List<ResultType> resultTypes) {
        this.board = new HashMap<>();
        calculateResult(resultTypes);
    }

    public Map<ResultType, Integer> getResult() {
        return Collections.unmodifiableMap(board);
    }

    public double getYieldRate(int amount) {
        int totalReward = getTotalReward();
        double yieldRate = getYieldRate(amount, totalReward);
        return Math.round(yieldRate * DECIMAL_PLACE) / DECIMAL_PLACE;
    }

    private void calculateResult(List<ResultType> resultTypes) {
        resultTypes
                .forEach(type -> board.put(type, increaseCount(type)));
    }

    private int increaseCount(ResultType type) {
        return board.getOrDefault(type, INIT_BOARD_COUNT) + INCREASE_COUNT;
    }

    private int getTotalReward() {
        return board.keySet().stream()
                .mapToInt(this::getReward)
                .sum();
    }

    private int getReward(ResultType key) {
        return key.getReward() * board.get(key);
    }

    private double getYieldRate(int amount, int totalReward) {
        return (double) totalReward / amount * PERCENTAGE;
    }
}
