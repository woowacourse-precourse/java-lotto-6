package lotto.constant;

public class ErrorMessage {

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";

    // money
    public static final String NOT_INTEGER_ERROR = "숫자가 아닙니다.";
    public static final String INSUFFICIENT_MONEY_ERROR = "금액이 부족합니다.";
    public static final String INAPPROPRIATE_MONEY_ERROR = "금액은 1000원 단위여야 합니다.";

    // lotto number
    public static final String INAPPROPRIATE_NUMBER_COUNT_ERROR = "로또 번호는 6개여야 합니다.";
    public static final String INAPPROPRIATE_NUMBER_ERROR = "로또 번호의 범위는 1 ~ 45여야 합니다.";
    public static final String DUPLICATED_NUMBER_ERROR = "로또 번호는 중복될 수 없습니다.";
    public static final String DUPLICATED_BONUS_NUMBER_ERROR = "보너스 번호는 중복될 수 없습니다.";

    public static String format(String message) {
        return ERROR_MESSAGE_HEADER + message;
    }
}
