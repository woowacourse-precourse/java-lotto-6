package lotto.constant;

public enum Error {
    BLANK("빈칸은 입력할 수 없습니다."),
    EMPTY_SPACE("공백을 포함하지 않는 숫자를 입력해주세요."),
    NOT_INTEGER("숫자를 입력해주세요."),
    OUT_OF_INTEGER_RANGE("정수 입력 범위를 초과했습니다."),
    OUT_OF_MAX_AMOUNT("1,000원 ~ 100,000원 사이의 금액을 입력해주세요."),
    THOUSAND_UNITS("구매금액은 1,000원 단위로 입력해주세요.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
