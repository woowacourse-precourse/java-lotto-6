package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.OutputConstants;
import lotto.domain.Lotto;
import lotto.domain.MatchNumber;

public class OutputView {
    private final static String AUTO_BUY_MESSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_COUNT_MESSAGE = "당첨 통계\n---";
    private final static String RATEOFRESULT_MESSAGE = "총 수익률은 %.2f%입니다.";


    public static void printException(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printAutoLottos(final List<Lotto> autoLottos, int lottoCount) {
        System.out.printf(String.format(AUTO_BUY_MESSAGE), lottoCount);
        printEmpty();

        StringBuilder result;
        for (Lotto lotto : autoLottos) {
            result = new StringBuilder();
            result.append(OutputConstants.LOTTO_PRINT_PREFIX.getConstants());
            lotto.getLotto().stream().map(String::valueOf).collect(Collectors.joining(","));
            result.append(OutputConstants.LOTTO_PRINT_SUFFIX.getConstants());
            System.out.print(result);
            printEmpty();
        }
    }

    private static void printResultCount(List<Integer> matchCount) {
        System.out.printf(String.format(WINNING_COUNT_MESSAGE));
        printEmpty();

        StringBuilder result;
        for (int i = 0; i < MatchNumber.getMembers().size(); i++) {
            MatchNumber match = MatchNumber.getMembers().get(i);
            result = new StringBuilder();
            result.append(match.getResultMessage()).append(OutputConstants.SPACE.getConstants());
            result.append(match.getMoneyMessage());
            result.append(OutputConstants.DASH.getConstants());
            result.append(String.format("%d개", matchCount.get(i)));
            System.out.print(result);
            printEmpty();
        }
    }

    private static void printRateOfResult(float rateOfResult) {
        System.out.printf(String.format(RATEOFRESULT_MESSAGE, rateOfResult * 100));
        printEmpty();
    }

    private static void printEmpty() {
        System.out.println();
    }

}
