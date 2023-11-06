package lotto.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_PREFIX + exceptionMessage);
    }

    public void printPurchaseAmountMessage() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }
}
