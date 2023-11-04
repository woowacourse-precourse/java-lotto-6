package lotto.View;

public class ErrorMessageView {

    static final String ERROR_COMMON = "[ERROR] ";

    static final String ERROR_WRONG_AMOUNT = "로또 구입 금액은 1000원 단위로 입력해야 합니다.";


    public static void printErrorWrongAmount() {
        System.out.println(ERROR_COMMON + ERROR_WRONG_AMOUNT);
    }
}
