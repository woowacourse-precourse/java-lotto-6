package lotto.view;

import lotto.domain.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String[] LOTTO_PRINT_FORMAT = {"[", "]"};
    private static final String LOTTO_WINNING_STATICS_START_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_WINNING_RATE_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String DELIMITER = ", ";

    public static void printPurchaseLottoCounts(PurchaseAmount purchaseAmount) {
        System.out.println(String.format(LOTTO_PURCHASE_COUNT_MESSAGE, purchaseAmount.getLottoCount()));
    }

    public static void printRandomLottoNumbers(PurchasedLottos purchasedLottos) {
        List<Lotto> lottos = purchasedLottos.getLottos();
        for (Lotto lotto : lottos) {
            printSingleLottoNumber(lotto);
        }
    }

    private static void printSingleLottoNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String singleLotto = numbers.stream()
                .map(number -> String.format("%d", number))
                .collect(Collectors.joining(DELIMITER, LOTTO_PRINT_FORMAT[0], LOTTO_PRINT_FORMAT[1]));
        System.out.println(singleLotto);
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(LOTTO_WINNING_STATICS_START_MESSAGE);

        Map<WinningRecord, Integer> winningResult = winningStatistics.getWinningStatistics();
        for (WinningRecord winningRecord : WinningRecord.getResultValues()) {
            System.out.println(winningRecord.getResultMessage(winningResult.get(winningRecord)));
        }
    }

    public static void printWinningRate(String winningRate) {
        System.out.println(String.format(LOTTO_WINNING_RATE_MESSAGE, winningRate));
    }
}
