package lotto.view;

public class OutputView {
    public static String askMoneyMessage = "구입금액을 입력해 주세요.";
    public static String askWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    public static String askBonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public static void printAskMoneyMessage() {
        System.out.println(askMoneyMessage);
    }

    public static void printAskWinningNumbersMessage() {
        System.out.println(askWinningNumbersMessage);
    }

    public static void printAskBonusNumberMessage() {
        System.out.println(askBonusNumberMessage);
    }
}
