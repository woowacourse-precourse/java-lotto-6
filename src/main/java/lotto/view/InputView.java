package lotto.view;

public class InputView {
    static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public void inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
