package lotto.constant;

public class ErrorMessage {

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    public static final String NOT_INTEGER_ERROR = "숫자가 아닙니다.";
    public static final String INSUFFICIENT_MONEY_ERROR = "금액이 부족합니다.";

    public static String format(String message) {
        return ERROR_MESSAGE_HEADER + message;
    }
}
