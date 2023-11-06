package lotto.constants;

public class ErrorMessage {

    public static final String ERROR_FORMAT = "[ERROR] ";

    // 모든 입력 공통
    public static final String BLANK_INPUT = "입력값이 빈 문자열입니다: ";
    public static final String SPACE_INCLUDED = "입력값 중간에 공백 문자를 포함할 수 없습니다.";
    public static final String NOT_INTEGER = "정수로 변환할 수 없는 문자열입니다: ";

    // 구입금액 입력 전용
    public static final String INDIVISIBLE_TO_THOUSAND = "1000원으로 나누어떨어지지 않는 금액입니다: ";
    public static final String NOT_POSITIVE = "입력된 금액이 양의 정수가 아닙니다: ";

    // 당첨 번호 입력, 보너스 번호 입력 공통
    public static final String INVALID_NUMBER = "입력된 번호가 1~45 사이 정수가 아닙니다: ";
    public static final String DUPLICATED_NUMBER = "입력된 번호는 이미 입력된 적 있는 번호입니다.";

    // 당첨 번호 입력 전용
    public static final String INVALID_COMMA = "쉼표(,)가 없거나 잘못 사용되었습니다: ";
    public static final String NOT_SIX_NUMBERS = "입력된 당첨 번호가 6개가 아닙니다.";
}
