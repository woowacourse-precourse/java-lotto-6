package View;

import java.util.List;

import static lotto.Constants.*;
public class OutputView {
    public static void printPurchaseResult(List<Integer> purchaseResult) {
        System.out.println(purchaseResult.size() + PURCHASE_COUNT_MESSAGE);
        purchaseResult.forEach(System.out::println);
    }

    public static void printWinningStatistics(List<Integer> winningStatistics) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(THREE_MATCHES_MESSAGE + winningStatistics.get(0));
        System.out.println(FOUR_MATCHES_MESSAGE + winningStatistics.get(1));
        System.out.println(FIVE_MATCHES_MESSAGE + winningStatistics.get(2));
        System.out.println(SIX_MATCHES_MESSAGE + winningStatistics.get(3));
    }

    public static void printReturnRate(float returnRate) {
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
