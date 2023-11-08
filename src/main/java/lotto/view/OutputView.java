package lotto.view;

import java.util.Map;
import lotto.model.Rank;

public class OutputView {
    private static final String DECORATOR = "---";
    private static final String WINNGING_GUIDE = "당첨 통계";

    public static void printWinningResult(Map<Rank, Integer> result, double revenue){
        System.out.println(DECORATOR);
        System.out.println(WINNGING_GUIDE);
        System.out.println(Rank.FIFTH.getResultMessage() + result.get(Rank.FIFTH) +"개");
        System.out.println(Rank.FOURTH.getResultMessage() + result.get(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getResultMessage() + result.get(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getResultMessage() + result.get(Rank.SECOND) +"개");
        System.out.println(Rank.FIRST.getResultMessage() + result.get(Rank.FIRST) +"개");
        System.out.printf((GuideMessage.REVENUE_GUIDE_MESSAGE.getMessage()) + "%n", revenue);
    }
}
