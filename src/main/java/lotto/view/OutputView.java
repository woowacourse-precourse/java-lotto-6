package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final int ZERO = 0;
    private static final String MESSAGE_PURCHASE_AMOUNT = "\n%d개를 구매했습니다.\n";
    private static final String MESSAGE_WIN_RATE = "\n당첨 통계";
    private static final String MESSAGE_BAR = "---";
    private static final String MESSAGE_WIN_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String MESSAGE_WIN_NORMAL = "%d개 일치 (%s원) - %d개\n";
    private static final String MESSAGE_YIELD_RATE = "총 수익률은 %.1f%%입니다.";

    public static void purchaseComplete(int count) {
        System.out.printf(MESSAGE_PURCHASE_AMOUNT, count);
    }

    public static void lottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void winningStatistics() {
        System.out.println(MESSAGE_WIN_RATE);
        System.out.println(MESSAGE_BAR);
    }

    public static void showRankResult(HashMap<Rank, Integer> map) {
        for (Rank rank : Rank.values()) {
            showSingleRankResult(map, rank);
        }
    }

    private static void showSingleRankResult(HashMap<Rank, Integer> map, Rank rank) {
        if (rank.getCount() == ZERO) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf(MESSAGE_WIN_WITH_BONUS,
                    rank.getCount(), rank.getConvertPrize(), map.get(rank));
            return;
        }
        System.out.printf(MESSAGE_WIN_NORMAL, rank.getCount(), rank.getConvertPrize(), map.get(rank));
    }

    public static void showYieldResult(double yield) {
        System.out.printf(MESSAGE_YIELD_RATE, yield);
    }
}
