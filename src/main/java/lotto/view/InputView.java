package lotto.view;

public class InputView {

    private static final String NEWLINE = "\n";
    private static String PaymentInputMsg = "구입금액을 입력해 주세요.";
    private static String NumberInputMsg = "당첨 번호를 입력해 주세요.";
    private static String BonusNumberInputMsg = NEWLINE + "보너스 번호를 입력해 주세요.";

    public static void inputPaymentMsg() {
        System.out.println(PaymentInputMsg);
    }

    public static void inputNumberMsg() {
        System.out.println(NumberInputMsg);
    }

    public static void inputBonusNumberMsg() {
        System.out.println(BonusNumberInputMsg);
    }
}
