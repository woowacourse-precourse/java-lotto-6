package lotto.constant;

public class ValidateConstant {
    public static String ERROR_DUPLICATE_NUMBERS() {
        return "[ERROR] 로또 번호에 중복이 있습니다.";
    }

    public static String ERROR_INCLUDE_STRING() {
        return "[ERROR] 입력에 문자가 포함되어 있습니다.";
    }

    public static String ERROR_INCLUDE_STRING_EXCEPTION_COMMA() {
        return "[ERROR] 입력에 숫자 or ',' 을 제외한 문자가 포함되어 있습니다.";
    }

    public static String ERROR_COMMA_START_END() {
        return "[ERROR] 숫자 입력의 처음 또는 끝이 ',' 입니다.";
    }
}
