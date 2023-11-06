package lotto.view;

public class LottoOutputView {
    private static final String USER_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String USER_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public void printUserInputPurchaseAmount() {
        System.out.println(USER_INPUT_PURCHASE_AMOUNT);
    }

    public void printUserInputWinningNumber() {
        System.out.println(USER_INPUT_WINNING_NUMBER);
    }
}
