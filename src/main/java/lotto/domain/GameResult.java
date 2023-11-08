package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private final Map<Rank, Integer> gameResult;

    private GameResult(Map<Rank, Integer> gameResult) {
        this.gameResult = gameResult;
    }

    public static GameResult createInitialResult() {
        Map<Rank, Integer> result = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, count -> 0));

        return new GameResult(result);
    }


    public void add(Rank rank) {
        gameResult.put(rank, gameResult.get(rank) + 1);
    }


    public double calculateProfitPercentage(Money money) {
        long profit = calculateProfit();

        return (double) profit / money.getAmount() * 100;
    }

    private long calculateProfit() {
        long profit = 0;
        for (Rank rank : Rank.values()) {
            profit += (long) rank.getPrizeMoney() * gameResult.get(rank);
        }
        return profit;
    }

    public int getCountOfRank(Rank rank) {
        return gameResult.get(rank);
    }
}
