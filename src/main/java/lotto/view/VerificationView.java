package lotto.view;

public class VerificationView {

    private final static String INPUT_MONEY_ERROR = "[ERROR] 구입 금액은 최소 1000원 이상, 1000원 단위의 금액입니다.";
    private final static String STRING_TO_LONG_ERROR = "[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.";

    public static void VerificationViewRangeInputMoney() {
        System.out.println(INPUT_MONEY_ERROR);
    }

    public static void VerificationViewStringToLong() {
        System.out.println(STRING_TO_LONG_ERROR);
    }
}
