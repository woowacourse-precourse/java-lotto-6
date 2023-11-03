package lotto.view;

public class InputView {
    private static final String MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static void showMessage(String message) {
        System.out.println(message);
    }

    public static void moneyMessage() {
        showMessage(MONEY_MESSAGE);
    }

    public static void numbersMessage() {
        showMessage(NUMBERS_MESSAGE);
    }

    public static void bonusNumberMessage() {
        showMessage(BONUS_NUMBER_MESSAGE);
    }
}
