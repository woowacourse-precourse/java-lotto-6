package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {

    private static Map<WinnerPrize, Integer> gameResult = new LinkedHashMap<>();

    public static void create() {
        WinnerPrize[] allWinnerPrize = WinnerPrize.getAllWinnerPrize();
        for (WinnerPrize winnerPrize : allWinnerPrize) {
            gameResult.put(winnerPrize, 0);
        }
    }

    public static void increaseWinnerPrizeCount(WinnerPrize winnerPrize) {
        gameResult.replace(winnerPrize, gameResult.get(winnerPrize) + 1);
    }

    public static Map<WinnerPrize, Integer> getGameResult() {
        return gameResult;
    }

    public static double calculateProfit(int purchasePrice) {
        double totalPrize = calculateTotalPrize();
        double profitRate = totalPrize / purchasePrice * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

    private static double calculateTotalPrize() {
        double prize = 0;
        for (WinnerPrize winnerPrize : gameResult.keySet()) {
            int count = gameResult.get(winnerPrize);
            prize += winnerPrize.getPrize() * count;
        }
        return prize;
    }
}
