package lotto.global.exception;

public class ErrorMessage {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String NOT_NUMBER = ERROR_MESSAGE + "해당 입력이 숫자가 아닙니다.";
    public static final String DUPLICATE = ERROR_MESSAGE + "중복되는 숫자가 있습니다.";
    public static final String OUT_OF_RANGE = ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ILLEGAL_AMOUNT = ERROR_MESSAGE + "금액이 1,000원으로 나누어 떨어지지 않습니다.";
    public static final String NUMBER_COUNT = ERROR_MESSAGE + "입력의 개수가 6이 아닙니다.";
}
