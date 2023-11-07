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
        System.out.println(WinningLevel.FIFTH_PLACE.getResult() + " - " + scoreBoard.get("5th") / WinningLevel.FIFTH_PLACE.getReward() + "개");
        System.out.println(WinningLevel.FOURTH_PLACE.getResult() + " - " + scoreBoard.get("4th") / WinningLevel.FOURTH_PLACE.getReward() + "개");
        System.out.println(WinningLevel.THIRD_PLACE.getResult() + " - " + scoreBoard.get("3rd") / WinningLevel.THIRD_PLACE.getReward() + "개");
        System.out.println(WinningLevel.SECOND_PLACE.getResult() + " - " + scoreBoard.get("2nd") / WinningLevel.SECOND_PLACE.getReward() + "개");
        System.out.println(WinningLevel.FIRST_PLACE.getResult() + " - " + scoreBoard.get("1st") / WinningLevel.FIRST_PLACE.getReward() + "개");
    }

    public static void outputViewTotalReturn(String totalReturn) {
        System.out.println(totalReturn);
    }
}
