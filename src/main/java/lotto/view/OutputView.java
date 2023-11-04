package lotto.view;

public class OutputView {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NEXT_LINE = "\n";

    public static void printPurchaseAmountRequest() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }

    public static void printNextLine() {
        System.out.print(NEXT_LINE);
    }
}
