package lotto.domain.view.printer;

public class InputPrinter {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputPrinter() {
    }

    public static void printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }

    public static void printWinningNumbers() {
        System.out.println(WINNING_NUMBERS_REQUEST_MESSAGE);
    }

    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }
}
