package lotto.domain;

import java.util.Map;

public class GameResult {
    private final Map<Rank, Integer> gameResult;

    public GameResult(Map<Rank, Integer> gameResult) {
        this.gameResult = gameResult;
    }

    public int calculateProfit() {
        int profit = 0;
        for (Rank rank : Rank.values()) {
            profit += rank.getPrizeMoney() * gameResult.get(rank);
        }
        return profit;
    }

    public int getCountOfRank(Rank rank) {
        return gameResult.get(rank);
    }
}
