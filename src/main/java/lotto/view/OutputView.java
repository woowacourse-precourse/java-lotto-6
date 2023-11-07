package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningResult;
import lotto.model.WinningStandard;

public class OutputView {
    private static final String OUTPUT_BUY_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String OUTPUT_STATICS_MESSAGE = "당첨 통계" + "\n" + "---";
    private static final String OUTPUT_WINNING_RESULT = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_WINNING_SECOND_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %,.1f%%입니다.";


    public static void printByLottoCount(Money money) {
        System.out.printf(OUTPUT_BUY_LOTTO_COUNT_MESSAGE + "\n", money.getLottoCount());
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printWinningResultAndRateOfReturn(WinningResult winningResult, double rateOfReturn) {
        System.out.println(OUTPUT_STATICS_MESSAGE);
        printWinningResult(winningResult);
        printRateOfRetrun(rateOfReturn);
    }

    private static void printRateOfRetrun(double rateOfReturn) {
        System.out.printf(OUTPUT_RATE_OF_RETURN, rateOfReturn);
        System.out.println();
    }

    private static void printWinningResult(WinningResult winningResult) {
        List<WinningStandard> sortedStandard = getSortedWinningStandard(winningResult);
        for (WinningStandard standard : sortedStandard) {
            if (standard == WinningStandard.ETC) {
                continue;
            }
            if (standard == WinningStandard.SECOND) {
                printSingleWinningResult(OUTPUT_WINNING_SECOND_RESULT, standard, winningResult);
                continue;
            }
            printSingleWinningResult(OUTPUT_WINNING_RESULT, standard, winningResult);
        }
    }

    private static void printSingleWinningResult(String format, WinningStandard standard, WinningResult winningResult) {
        System.out.printf(format, standard.getMatchCount(),
                String.format("%,d", standard.getWinningAmount()),
                winningResult.getWinningResult().get(standard));
        System.out.println();
    }

    private static List<WinningStandard> getSortedWinningStandard(WinningResult winningResult) {
        return winningResult.getWinningResult().keySet()
                .stream()
                .sorted(Comparator.comparingInt(WinningStandard::getWinningAmount))
                .collect(Collectors.toList());
    }
}
