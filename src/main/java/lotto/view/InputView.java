package lotto.view;

public class InputView {
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_LOTTO_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public static void inputAmount() {
        System.out.println(MESSAGE_INPUT_MONEY);
    }

    public static void inputWinningNumbers() {
        System.out.println(MESSAGE_INPUT_LOTTO_NUMBER);
    }

    public static void inputBonusNumber() {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
    }
}
