package lotto;

public class OutputView {
    private static final String REQUEST_INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public void printRequestInputBuyMoney() {
        System.out.println(REQUEST_INPUT_BUY_MONEY_MESSAGE);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
