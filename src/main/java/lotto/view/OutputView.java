package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_TICKET_COUNT = "개를 구매했습니다.";

    public static void printLottoCount(int count) {
        System.out.println();
        System.out.println(count + OUTPUT_TICKET_COUNT);
    }

    public static void printPurchasedLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResult(Rank rank, Map<Rank, Integer> result) {
        System.out.println(rank.getContent() + result.get(rank) + "개");
    }

    public static void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}