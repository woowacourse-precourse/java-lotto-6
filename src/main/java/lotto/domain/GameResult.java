package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.dto.GameResultDto;

public class GameResult {
    private static final float PERCENTAGE_MULTIPLIER = 100.0f;
    private final Map<Prize, Integer> prizeCounter;

    private GameResult() {
        this.prizeCounter = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.valuesWithoutDefault()) {
            prizeCounter.put(prize, 0);
        }
    }

    public static GameResult create() {
        return new GameResult();
    }

    public void incrementPrizeCount(Prize prize) {
        prizeCounter.put(prize, prizeCounter.get(prize) + 1);
    }

    public float getWinningPercentage(int buyAmount) {
        return (float) getTotalWinningAmount() * PERCENTAGE_MULTIPLIER / buyAmount;
    }

    private long getTotalWinningAmount() {
        return prizeCounter.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public GameResultDto getGameResultDto(Order order) {
        return new GameResultDto(prizeCounter, getWinningPercentage(order.getBuyAmount()));
    }
}
