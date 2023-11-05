package lotto.system;

public class ErrorMessage {

    private ErrorMessage() {}
    public static final String IS_NOT_DIVISIBLE = "[ERROR] 금액이 " + Constants.MONEY_UNIT + " 으로 떨어지지 않는 값을 입력했습니다.";
    public static final String IS_NOT_NUMERIC = "[ERROR] 숫자가 아닌 입력 입니다.";
    public static final String OUT_OF_RANGE = "[ERROR] 입력 범위가 너무 큽니다.";
    public static final String IS_NOT_POSITIVE = "[ERROR] 입력 값은 음수 입니다.";

}
