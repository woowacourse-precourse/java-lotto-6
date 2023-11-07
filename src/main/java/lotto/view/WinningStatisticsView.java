package lotto.view;

import lotto.domain.Match;

import java.util.Map;

import static lotto.domain.Match.*;

public class WinningStatisticsView {
    private static final String winningStatic = "\n당첨 통계\n---";
    private static final String matchThree = "3개 일치 (5,000원) - ";
    private static final String matchFour = "4개 일치 (50,000원) - ";
    private static final String matchFive = "5개 일치 (1,500,000원) - ";
    private static final String matchFiveBonus = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String matchSix = "6개 일치 (2,000,000,000원) - ";
    private static final String number = "개";

    public void printWinningStatistics(Map<Match, Integer> winningCount) {
        System.out.println(winningStatic);
        printWinningCount(winningCount);
    }

    private void printWinningCount(Map<Match, Integer> winningCount) {
        System.out.println(makePrint(matchThree, winningCount, THREE));
        System.out.println(makePrint(matchFour, winningCount, FOUR));
        System.out.println(makePrint(matchFive, winningCount, FIVE));
        System.out.println(makePrint(matchFiveBonus,winningCount,FIVE_BONUS));
        System.out.println(makePrint(matchSix, winningCount, SIX));
    }

    private String makePrint(String startMessage, Map<Match, Integer> winningCount, Match key) {
        return startMessage + getCount(winningCount, key) + number;
    }

    private int getCount(Map<Match, Integer> winningCount, Match key) {
        if (winningCount.containsKey(key)) {
            return winningCount.get(key);
        }
        return 0;
    }
}
