package lotto.console;

import lotto.constant.ConsoleMessage;
import lotto.model.Capital;
import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.WinningDetails;

import java.util.List;

public class OutputConsole {

    public static void printErrorMessage(Exception e) {
        System.out.println(ConsoleMessage.ERROR_PREFIX + " " + e.getMessage());
    }

    public static void printInputPrompt(String promptMessage) {
        System.out.println(promptMessage);
    }

    public static void printPlayerPurchases(Player player) {
        printNumberOfPurchasedLotto(player.getCapital());
        printLottoDetails(player.getLottos());
    }

    private static void printNumberOfPurchasedLotto(Capital capital) {
        System.out.printf("%d개를 구매했습니다.\n", capital.getNumberOfPurchasedLotto());
    }

    private static void printLottoDetails(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printWinningDetails(WinningDetails winningDetails) {
        System.out.println(ConsoleMessage.DETAILS_TITLE);
        System.out.println(ConsoleMessage.DIVIDER);

        winningDetails.breakdown().forEach((lotteryRank, count) -> {
            printEachDetail(lotteryRank.getMessage(), count);
        });

        printROI(winningDetails.returnOnInvestment());
    }

    private static void printEachDetail(String message, int count) {
        System.out.printf("%s - %d개\n", message, count);
    }

    private static void printROI(double returnOnInvestment) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnOnInvestment);
    }

}
