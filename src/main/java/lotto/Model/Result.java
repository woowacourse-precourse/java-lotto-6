package lotto.Model;

import java.util.List;
import lotto.View.OuputView;

public class Result {
    public static void printResults(List<Integer> countWinnings) {
        OuputView.resultPrint();
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize != LottoPrize.FAIL) {
                int prizeCount = countWinnings.get(prize.ordinal());
                System.out.println(prize.getDescription() + " - " + prizeCount + "개");
            }
        }
    }

}
