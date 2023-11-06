package lotto.view;

public class ErrorMessage {
    public static final String NON_NUMERIC_PURCHASE_AMOUNT = "[ERROR] 구입금액은 숫자로 입력해야 합니다.";

    public static void printNonNumericAmountError() {
        System.out.println(NON_NUMERIC_PURCHASE_AMOUNT);
    }
}
