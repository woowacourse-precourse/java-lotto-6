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
        printLineBreakMessage("당첨 통계");
        printMessage("---");
        for (WinningKind winningKind : WinningKind.values()) {
            printMessage(
                    winningKind.getExplanation()
                            + " (" + String.format("%,d", winningKind.getPrice()) + ") - "
                            + winningResult.get(winningKind) + "개"
            );
        }
    }
}
