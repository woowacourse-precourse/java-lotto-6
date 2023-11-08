package lotto.view;

import lotto.configuration.WinningLevel;

import java.util.HashMap;
import java.util.StringJoiner;

public class OutputView {

    private final static String DASH = "-";
    private final static String STATISTICS = "당첨 통계";
    private final static String PURCHASE_COUNT = "개를 구매했습니다.";

    public static void outputViewPurchaseCount(long count) {
        System.out.println();
        System.out.println(count + PURCHASE_COUNT);
    }

    public static void lottoNumbersResult(StringJoiner joiner) {
        System.out.println(joiner.toString());
    }

    public static void outputViewStatistics(HashMap<String, Long> scoreBoard) {
        System.out.println();
        System.out.println(STATISTICS);
        System.out.println(DASH.repeat(3));
        System.out.println(WinningLevel.FIFTH.getResult() + " - " + scoreBoard.get("5th") / WinningLevel.FIFTH.getReward() + "개");
        System.out.println(WinningLevel.FOURTH.getResult() + " - " + scoreBoard.get("4th") / WinningLevel.FOURTH.getReward() + "개");
        System.out.println(WinningLevel.THIRD.getResult() + " - " + scoreBoard.get("3rd") / WinningLevel.THIRD.getReward() + "개");
        System.out.println(WinningLevel.SECOND.getResult() + " - " + scoreBoard.get("2nd") / WinningLevel.SECOND.getReward() + "개");
        System.out.println(WinningLevel.FIRST.getResult() + " - " + scoreBoard.get("1st") / WinningLevel.FIRST.getReward() + "개");
    }

    public static void outputViewTotalReturn(String totalReturn) {
        System.out.println(totalReturn);
    }
}
