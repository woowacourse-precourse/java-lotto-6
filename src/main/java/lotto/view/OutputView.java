package lotto.view;

public class OutputView {

    private static final String READ_MONEY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public void printReadMoneyAmountMessage() {
        System.out.println(READ_MONEY_AMOUNT_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
