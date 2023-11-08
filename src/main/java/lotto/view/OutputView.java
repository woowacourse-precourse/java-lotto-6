package lotto.view;

import static lotto.util.Util.formatCurrency;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public static final String INPUT_FOR_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String COMPLETE_PURCHASE = "개를 구매했습니다.";
    public static final String INPUT_FOR_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_FOR_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_INFO = "\n당첨 통계";
    public static final String CONTOUR = "---";
    public static final String NEW_LINE = "\n";
    public static final String PRINT_SECOND_RANK_RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    public static final String PRINT_OTHER_RANK_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    public static final String PRINT_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void askPurchaseAmount() {
        System.out.println(INPUT_FOR_PURCHASE_AMOUNT);
    }

    public static void printCompletePurchase(int purchaseCount, List<Lotto> lottoNumbers) {
        System.out.println(NEW_LINE + Lotto.getLottoCount(purchaseCount) + COMPLETE_PURCHASE);
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.ascendingSort());
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
            System.out.printf(PRINT_SECOND_RANK_RESULT_FORMAT, rank.getNumberOfMatch(),
                    formatCurrency(rank.getWinnings()), count);
            return;
        }
        System.out.printf(PRINT_OTHER_RANK_RESULT_FORMAT, rank.getNumberOfMatch(),
                formatCurrency(rank.getWinnings()), count);
    }

    public static void printRateOfReturn(float rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN_FORMAT, rateOfReturn);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
