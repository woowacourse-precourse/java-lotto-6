package lotto.view;

import static lotto.constants.Message.SHOW_EARNING_RATE;
import static lotto.constants.Message.SHOW_PURCHASE_LOTTO;
import static lotto.constants.Message.SHOW_WINNING_STATISTICS;

import java.util.LinkedHashMap;
import java.util.List;
import lotto.constants.LottoPrize;
import lotto.domain.Lotto;

public class OutputView {
    private OutputView() {
    }

    public static void displayPurchasedLotto(int number, List<Lotto> lottos) {
        System.out.println();
        System.out.printf(SHOW_PURCHASE_LOTTO.getMessage(), number);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }

    public static void displayWinningStatistics(LinkedHashMap<LottoPrize, Integer> statistics, double rate) {
        System.out.println();
        System.out.println(SHOW_WINNING_STATISTICS.getMessage());
        for (LottoPrize prize : statistics.keySet()) {
            System.out.printf(prize.getDescription(), statistics.get(prize));
        }
        System.out.printf(SHOW_EARNING_RATE.getMessage(), rate);
    }

    public static void displayError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
