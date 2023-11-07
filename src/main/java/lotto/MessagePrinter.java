package lotto;

import static lotto.Util.formatCurrency;

import java.util.List;
import java.util.Map;

public class MessagePrinter {
    public static final String INPUT_FOR_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    public static final String COMPLETE_PURCHASE = "개를 구매했습니다.";
    public static final String INPUT_FOR_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_FOR_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_INFO = "\n당첨 통계";
    public static final String CONTOUR = "---";
    public static final String NEW_LINE = "\n";
    public static final String printSecondRankResult = "%d개 일치 (%s원) - %d개\n";
    public static final String printOtherRankResult = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";

    public static void askPurchaseAmount() {
        System.out.println(INPUT_FOR_PURCHASE_AMOUNT);
    }

    public static void printCompletePurchase(int purchaseCount, List<Lotto> lottoNumbers) {
        System.out.println(NEW_LINE + purchaseCount + COMPLETE_PURCHASE);
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
        System.out.println();
    }

    public static void askWinningLotto() {
        System.out.println(INPUT_FOR_WINNING_LOTTO);
    }

    public static void askBonusNumber() {
        System.out.println(INPUT_FOR_BONUS_NUMBER);
    }

    public static void printWinningStatistics(Map<Rank, Integer> rankResult) {
        System.out.println(WINNING_STATISTICS_INFO);
        System.out.println(CONTOUR);
        printWinningResult(rankResult);
    }

    private static void printWinningResult(Map<Rank, Integer> rankResult) {
        for (Map.Entry<Rank, Integer> entry : rankResult.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            getRankMessage(rank, count);
        }
    }

    private static void getRankMessage(Rank rank, Integer count) {
        if (rank != Rank.SECOND) {
            System.out.printf(printSecondRankResult, rank.getNumberOfMatch(), formatCurrency(rank.getWinnings()), count);
            return;
        }
        System.out.printf(printOtherRankResult, rank.getNumberOfMatch(), formatCurrency(rank.getWinnings()), count);
    }
}
