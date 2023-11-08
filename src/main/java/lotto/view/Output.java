package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class Output {
    public static final String PURCHASE_AMOUNT_NOTICE = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTO_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_NOTICE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_NOTICE = "보너스 번호를 입력해 주세요.";
    public static final String STATISTICS_NOTICE = "당첨 통계";
    public static final String BR_LINE = "---";
    public static final String RESULT_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";
    public static final String RESULT_OTHER_MESSAGE = "%d개 일치 (%s) - %d개\n";
    public static final String RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_NOTICE);
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASED_LOTTO_MESSAGE);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningNumberMessage() {
        System.out.println(WINNING_NUMBER_NOTICE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_NOTICE);
    }

    public static void printStatisticsMessage() {
        System.out.println(STATISTICS_NOTICE);
        System.out.println(BR_LINE);
    }

    public static void printResults(HashMap<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            printResult(rank, result);
        }
    }

    private static void printResult(Rank rank, HashMap<Rank, Integer> result) {
        if (rank == Rank.NONE) {
            return;
        }

        if (rank == Rank.SECOND) {
            System.out.printf(RESULT_SECOND_MESSAGE, rank.getWinningMatchCount(), rank.getPrizeOutput(),
                              result.get(rank));
            return;
        }
        System.out.printf(RESULT_OTHER_MESSAGE, rank.getWinningMatchCount(), rank.getPrizeOutput(), result.get(rank));
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf(RETURN_RATE_MESSAGE, returnRate);
    }
}
