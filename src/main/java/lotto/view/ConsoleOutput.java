package lotto.view;

public class ConsoleOutput {
    private static final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String EXTRA_WINNING_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";

    public static void displayUserInputPrompt() {
        System.out.println(PURCHASE_PROMPT);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void displayWinningNumberPrompt() {
        System.out.println(WINNING_NUMBER_PROMPT);
    }

    public static void displayExtraWinningNumberPrompt() {
        System.out.println(EXTRA_WINNING_NUMBER_PROMPT);
    }

    public static void displayWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }
}
