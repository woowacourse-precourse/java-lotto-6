package lotto.view;

public class ErrorView {

    public static String getRangeErrorMessage() {
        return "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    }

    public static String getDuplicateErrorMessage() {
        return "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    }

    public static String getLengthErrorMessage() {
        return "[ERROR] 로또 번호는 6개여야 합니다.";
    }

    public static String getInvalidAmountErrorMessage() {
        return "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    }

    public static String getInvalidInputFormatErrorMessage() {
        return "[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자여야 합니다.";
    }

}
