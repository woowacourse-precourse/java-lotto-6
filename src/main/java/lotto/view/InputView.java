package lotto.view;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LINE = "\n";

    public static void getAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
    }

    public static void getWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
    }

    public static void getBonusNumber() {
        System.out.println(LINE + ENTER_BONUS_NUMBER);
    }
}
