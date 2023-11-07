package lotto.view;

public class VerificationView {

    private final static String INPUT_MONEY_ERROR = "구입 금액은 최소 1000원 이상, 1000원 단위의 금액입니다.";

    public static void VerificationViewInputMoney() {
        System.out.println(INPUT_MONEY_ERROR);
    }
}
