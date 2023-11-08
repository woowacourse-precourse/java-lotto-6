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

    public static String ERROR_CONSECUTIVE_EMPTY_VALUES() {
        return "[ERROR] 문자열 \",,\" 사이에 숫자가 없습니다.";
    }

    public static String ERROR_BLANK_CHECK() {
        return "[ERROR] 빈칸은 입력할 수 없습니다.";
    }

    public static String ERROR_INCLUDE_BLANK() {
        return "[ERROR] 입력 중간에 공백이 포함되어 있습니다.";
    }

    public static String ERROR_INPUT_NEGATIVE() {
        return "[ERROR] 양수만 입력해 주세요";
    }

    public static String ERROR_INPUT_ZERO_NUMBER() {
        return "[ERROR] 양수만 입력해 주세요";
    }
}
