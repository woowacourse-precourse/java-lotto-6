package lotto.view;

public class InputView {
    private static final String REQUEST_TO_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_TO_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_TO_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_TAG = "[ERROR]";

    public void showAmountInputForm() {
        System.out.println(REQUEST_TO_INPUT_PURCHASE_AMOUNT);
    }

    public void showWinningNumbersInputForm() {
        System.out.println(REQUEST_TO_INPUT_WINNING_NUMBERS);
    }

    public void showBonusNumberInputForm() {
        System.out.println(REQUEST_TO_INPUT_BONUS_NUMBER);
    }

    public void endInput() {
        System.out.println();
    }

    public void showInputErrorMessage(String message) {
        System.out.println(ERROR_TAG + " " + message);
    }
}
