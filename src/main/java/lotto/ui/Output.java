package lotto.ui;

import java.util.Collections;
import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lotto;

public class Output {
    private static final String NEW_LINE = "\n";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String COUNT_UNIT = "개";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLotto(List<Lotto> lotteries) {
        int count = lotteries.size();
        System.out.println(NEW_LINE + count + PURCHASE_MESSAGE);
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
            System.out.println(rank.getMessage() + count + COUNT_UNIT);
        }
    }
}
