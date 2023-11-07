package lotto.ui;

import java.util.List;
import lotto.Constants;

public class PrintWinningResultUI {

    public void printWinningResultUI(List<Integer> matchingResult) {
        System.out.println();
        System.out.println(Constants.PRIZE_RESULT);
        System.out.println("---");

        for (int i = 0; i < matchingResult.size(); i++) {
            if (i == 0) {
                printWinningCount(3, matchingResult.get(i), false);
                continue;
            }

            if (i == 1) {
                printWinningCount(4, matchingResult.get(i), false);
                continue;
            }

            if (i == 2) {
                printWinningCount(5, matchingResult.get(i), false);
                continue;
            }

            if (i == 3) {
                printWinningCount(5, matchingResult.get(i), true);
                continue;
            }

            if (i == 4) {
                printWinningCount(6, matchingResult.get(i), false);
            }
        }
    }

    private void printWinningCount(int matchingCount, int winningCount, boolean isBonusMatched) {

        if (matchingCount == 6) {
            System.out.println(Constants.PRIZE_MATCH_6 + winningCount + "개");
        }

        if (matchingCount == 5 && isBonusMatched) {
            System.out.println(Constants.PRIZE_MATCH_5_BONUS + winningCount + "개");
        }

        if (matchingCount == 5 && !isBonusMatched) {
            System.out.println(Constants.PRIZE_MATCH_5 + winningCount + "개");
        }

        if (matchingCount == 4) {
            System.out.println(Constants.PRIZE_MATCH_4 + winningCount + "개");
        }

        if (matchingCount == 3) {
            System.out.println(Constants.PRIZE_MATCH_3 + winningCount + "개");
        }

    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
