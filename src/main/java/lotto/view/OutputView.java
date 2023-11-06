package lotto.view;

import static lotto.constants.Notice.PROFIT_RATE;
import static lotto.constants.Notice.PURCHASE_RESULT;
import static lotto.constants.Notice.WINNING_RESULT;
import static lotto.constants.Rank.FIFTH;
import static lotto.constants.Rank.FIRST;
import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {
    private static final String UNIT = "개";

    public static void printPurchaseResult(List<Lotto> lottos) {
        int quantity = lottos.size();
        System.out.println();
        System.out.println(quantity + PURCHASE_RESULT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningResult(Map<Integer, Integer> winningResult) {
        System.out.println();
        System.out.println(WINNING_RESULT.getMessage());
        System.out.println(FIFTH.getMessage() + winningResult.get(5) + UNIT);
        System.out.println(FOURTH.getMessage() + winningResult.get(4) + UNIT);
        System.out.println(THIRD.getMessage() + winningResult.get(3) + UNIT);
        System.out.println(SECOND.getMessage() + winningResult.get(2) + UNIT);
        System.out.println(FIRST.getMessage() + winningResult.get(1) + UNIT);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE.getMessage(), profitRate);
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }


}
