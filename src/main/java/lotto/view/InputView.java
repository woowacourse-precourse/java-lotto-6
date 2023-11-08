package lotto.view;

public class InputView {

    private static final String NEWLINE = "\n";
    private static String PAYMENT_INPUT_MSG = "구입금액을 입력해 주세요.";
    private static String NUMBER_INPUT_MSG = "당첨 번호를 입력해 주세요.";
    private static String BONUS_NUMBER_INPUT_MSG = NEWLINE + "보너스 번호를 입력해 주세요.";

    public static void inputPaymentMsg() {
        System.out.println(PAYMENT_INPUT_MSG);
    }

    public static void inputNumberMsg() {
        System.out.println(NUMBER_INPUT_MSG);
    }

    public static void inputBonusNumberMsg() {
        System.out.println(BONUS_NUMBER_INPUT_MSG);
    }
}
