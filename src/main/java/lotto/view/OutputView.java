package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String TICKET_SIZE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f%%입니다.";
    private static final String ERROR_MESSAGE = "[ERROR] ";


    public static void printGeneratedLotto(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + TICKET_SIZE_MESSAGE);

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatistics(List<Integer> winningCounts) {
        System.out.println("\n" + WINNING_STATISTICS_MESSAGE);
        System.out.println(SEPARATOR);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
    }

    public static void printErrorMessage(String detailErrorMessage) {
        System.out.println(ERROR_MESSAGE + detailErrorMessage);
    }
}
