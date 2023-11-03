package lotto.Model;

import java.util.List;

public class Result {
    public static void printResults(List<Integer> countWinnings) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize != LottoPrize.FAIL) {
                int prizeCount = countWinnings.get(prize.ordinal());
                System.out.println(prize.getDescription() + " - " + prizeCount + "개");
            }
        }
    }

}
