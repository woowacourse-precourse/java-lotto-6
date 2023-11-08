package lotto.console;

import lotto.constant.ConsoleMessage;
import lotto.model.WinningDetails;

public class OutputConsole {

    public static void printErrorMessage(Exception e) {
        System.out.println(ConsoleMessage.ERROR_PREFIX + " " + e.getMessage());
    }

    public static void printInputPrompt(String promptMessage) {
        System.out.println(promptMessage);
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
        System.out.printf("%s - %d개", message, count);
    }

    private static void printROI(double returnOnInvestment) {
        System.out.printf("총 수익률은 %f%%입니다.", returnOnInvestment);
    }

}
