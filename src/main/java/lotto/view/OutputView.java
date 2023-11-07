package lotto.view;

import static lotto.model.WinningResult.calculateEarning;
import static lotto.model.WinningResult.printWinningResult;
import static lotto.util.message.Guide.EARNING_RATE;
import static lotto.util.message.Guide.WINNING_RESULT_STATISTICS;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.message.Guide;

public class OutputView {

    public static void printError(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printLottoInfo(List<Lotto> lottos, int count) {
        System.out.println(Guide.LOTTO_COUNT.getMessage(count));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printResultStatistics(int purchaseMoney) {
        System.out.println(WINNING_RESULT_STATISTICS.getMessage());

        printWinningResult();
        System.out.printf(EARNING_RATE.getMessage(), calculateEarning(purchaseMoney) + "%");
    }
}
