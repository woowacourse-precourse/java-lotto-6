package lotto.view;

public class ConsoleView {

    private static final String inputPurchaseAmountMessage = "구입금액을 입력해 주세요.";
    private static final String purchaseConfirmationMessage = "8개를 구매했습니다.";
    private static final String inputWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    private static final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";
    private static final String winningStatisticsMessage = "당첨 통계\n---";

    public static void printInputPurchaseAmountMessage() {
        System.out.println(inputPurchaseAmountMessage);
    }

    public static void printPurchaseConfirmationMessage(int n) {
        System.out.println(n + purchaseConfirmationMessage);
    }

    public static void printInputWinningNumbersMessage() {
        System.out.println(inputWinningNumbersMessage);
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(inputBonusNumberMessage);
    }

    public static void printWinningStatistics() {
        System.out.println(winningStatisticsMessage);
    }
}
