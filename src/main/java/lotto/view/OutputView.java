package lotto.view;

public class OutputView {

    private static final String READ_COST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public void printReadCostAmountMessage() {
        System.out.println(READ_COST_AMOUNT_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
