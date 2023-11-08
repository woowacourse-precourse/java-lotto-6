package lotto;

import java.util.List;
import java.util.Map;

public class OutputHandler {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLineBreakMessage(String message) {
        System.out.println();
        printMessage(message);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatistics(Map<WinningKind, Integer> winningResult) {
        LottoHandler lottoHandler = new LottoHandler();
        printLineBreakMessage("당첨 통계");
        printMessage("---");

        for (WinningKind winningKind : WinningKind.values()) {
            printMessage(
                    winningKind.getExplanation()
                            + " (" + lottoHandler.formatPrice(winningKind.getPrice()) + "원) - "
                            + winningResult.get(winningKind) + "개"
            );
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        printMessage("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
