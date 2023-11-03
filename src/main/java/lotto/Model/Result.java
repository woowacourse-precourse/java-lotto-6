package lotto.Model;

import java.util.List;

public class Result {
    public static void printResults(List<Integer> countWinnings) {
        for (LottoPrize prize : LottoPrize.values()) {
            int prizeCount = countWinnings.get(prize.ordinal());
            System.out.println(prize.getDescription() + " - " + prizeCount + "개");
        }
    }

}
