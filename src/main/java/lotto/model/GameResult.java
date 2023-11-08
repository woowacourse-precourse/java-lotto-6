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
}
