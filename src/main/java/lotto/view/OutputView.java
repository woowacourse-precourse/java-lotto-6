package lotto.view;

import lotto.configuration.Rank;

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
        System.out.println(Rank.FIFTH.getResult() + " - " + scoreBoard.get("5th") / Rank.FIFTH.getReward() + "개");
        System.out.println(Rank.FOURTH.getResult() + " - " + scoreBoard.get("4th") / Rank.FOURTH.getReward() + "개");
        System.out.println(Rank.THIRD.getResult() + " - " + scoreBoard.get("3rd") / Rank.THIRD.getReward() + "개");
        System.out.println(Rank.SECOND.getResult() + " - " + scoreBoard.get("2nd") / Rank.SECOND.getReward() + "개");
        System.out.println(Rank.FIRST.getResult() + " - " + scoreBoard.get("1st") / Rank.FIRST.getReward() + "개");
    }

    public static void outputViewTotalReturn(String totalReturn) {
        System.out.println(totalReturn);
    }
}
