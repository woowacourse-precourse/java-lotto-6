package lotto.view;

public final class OutputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private OutputView() {
    }

    public static void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printWinningNumbersMessage() {
        printEmptyLine();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        printEmptyLine();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
