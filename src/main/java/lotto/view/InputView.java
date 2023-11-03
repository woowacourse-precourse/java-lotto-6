package lotto.view;

public class InputView {

    private static final String purchaseAmountInput = "구입금액을 입력해 주세요.";
    private static final String winningNumberInput = "당첨 번호를 입력해 주세요.";
    private static final String bonusNumberInput = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(purchaseAmountInput);
        return System.console().readLine();
    }

    public String inputWinningNumber() {
        System.out.println(winningNumberInput);
        return System.console().readLine();
    }

    public String inputBonusNumber() {
        System.out.println(bonusNumberInput);
        return System.console().readLine();
    }
}
