package lotto.util;

public class ErrorProperties {
    private static String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자(금액)를 입력하세요.";
    private static String ERROR_MESSAGE_MONEY_UNIT = "[ERROR] 구입 금액 단위는 1000원 입니다.";
    private static String ERROR_MESSAGE_SIZE = "[ERROR] 로또 번호 개수는 총 6개입니다.";
    private static String ERROR_MESSAGE_DUPLICATION = "[ERROR] 로또 번호는 중복이 허용되지 않습니다.";

    public static String getErrorMessageDuplication() {
        return ERROR_MESSAGE_DUPLICATION;
    }

    public static String getErrorMessageSize() {
        return ERROR_MESSAGE_SIZE;
    }
    public static String getErrorMessageMoneyUnit() {
        return ERROR_MESSAGE_MONEY_UNIT;
    }
    public static String getErrorMessageNotInt() {
        return ERROR_MESSAGE_NOT_INT;
    }

}
