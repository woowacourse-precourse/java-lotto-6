package lotto.view;

public class OutputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private void printWithNewLine(String s) {
        System.out.println(s);
    }

    private void print(String s) {
        System.out.print(s);
    }

    public void printPurchaseAmountMessage() {
        printWithNewLine(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printErrorMessage(String message) {
        printWithNewLine(message);
    }
}
