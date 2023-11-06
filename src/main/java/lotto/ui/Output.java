package lotto.ui;

import java.util.Collections;
import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lotto;

public class Output {
    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String EARNINGS_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLotto(List<Lotto> lotteries) {
        int count = lotteries.size();
        System.out.printf(PURCHASE_MESSAGE, count);
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(List<Rank> result) {
        System.out.println(RESULT_MESSAGE);
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SIXTH) {
                continue;
            }
            int count = Collections.frequency(result, rank);
            System.out.printf(rank.getMessage(), count);
        }
    }

    public static void printEarnings(double earnings) {
        System.out.printf(EARNINGS_MESSAGE, earnings);
    }
}
