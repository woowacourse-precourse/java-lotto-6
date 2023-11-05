package lotto.constants;

public enum ErrorMessage {

    BLANK_NOT_ALLOWED("공백으로만 이루어진 문자열을 입력할 수 없습니다."),
    EMPTY_NOT_ALLOWED("빈 문자열을 입력할 수 없습니다."),
    START_WITH_DELIMITER_NOT_ALLOWED("구분자인 %s로 시작하는 문자열을 입력할 수 없습니다."),
    ENDS_WITH_DELIMITER_NOT_ALLOWED("구분자인 %s로 끝나는 문자열을 입력할 수 없습니다."),
    ONLY_NUMBER_OR_DELIMITER_ALLOWED("구분자 %s와 숫자로 구성된 문자열만을 입력할 수 있습니다."),
    CONSECUTIVE_DELIMITER_NOT_ALLOWED("구분자 %s를 연속해서 입력할 수 없습니다."),

    ONLY_NUMBER_ALLOWED("숫자만 입력할 수 있습니다."),
    LOTTO_RANGE_NUMBER_ALLOWED("1에서 45 사이의 숫자만 입력할 수 있습니다."),
    ALREADY_USED_NUMBER_NOT_ALLOWED("로또에 이미 있는 번호는 입력할 수 없습니다."),

    DIVISIBLE_BY_THOUSAND_ALLOWED("1000원 단위만 입력할 수 있습니다."),
    ZERO_OR_LESS_NOT_ALLOWED("0 이하의 수는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}