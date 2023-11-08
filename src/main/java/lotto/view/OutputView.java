package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private final static String INPUT_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.\n";
    private final static String PURCHASE_MSG = "%d개를 구매했습니다.\n";
    private final static String INPUT_LOTTO_NUMBER_MSG = "당첨 번호를 입력해 주세요.\n";
    private final static String INPUT_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.\n";
    private final static String WINNING_STATISTICS_MSG = "당첨 통계\n" + "---\n";
    private final static String WINNING_RESULT_MSG = "%d개 일치 (%d원) - %d개";
    private final static String TOTAL_PROFIT_RATE_MSG = "총 수익률은 %.2f%%입니다.\n";

    public static void printInputPurchaseAmountMsg() {
        System.out.print(INPUT_PURCHASE_AMOUNT_MSG);
    }

    public static void printPurchaseMsg(int lottoCount) {
        System.out.printf(PURCHASE_MSG, lottoCount);
    }

    private static void printLotto(Lotto lotto) {
        // Lotto 객체의 toString() 메서드를 사용하여 출력
        System.out.println(lotto.getNumbers().toString());
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public static void printInputWinningNumberMsg() {
        System.out.print(INPUT_LOTTO_NUMBER_MSG);
    }

    public static void printInputBonusNumberMsg() {
        System.out.print(INPUT_BONUS_NUMBER_MSG);
    }

    public static void printWinningStatistics() {
        System.out.print(WINNING_STATISTICS_MSG);
    }

    public static void printWinningResult(int matchCount, int prize, int count) {
        System.out.printf(WINNING_RESULT_MSG, matchCount, prize, count);
        System.out.println();
    }

    public static void printTotalProfitRate(double profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_MSG, profitRate);
    }
}
