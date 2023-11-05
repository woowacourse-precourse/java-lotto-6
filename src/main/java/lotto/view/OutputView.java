package lotto.view;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public void println() {
        System.out.println();
    }

    public void printError(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }


}
