package lotto.constant;

public enum ErrorText {
    BLANK("빈칸은 입력할 수 없습니다."),
    EMPTY_SPACE("공백을 포함하지 않는 숫자를 입력해주세요."),
    NOT_INTEGER("숫자를 입력해주세요."),
    OUT_OF_INTEGER_RANGE("정수 입력 범위를 초과했습니다."),
    OUT_OF_MAX_AMOUNT("1,000원 ~ 100,000원 사이의 금액을 입력해주세요."),
    THOUSAND_UNITS("구매금액은 1,000원 단위로 입력해주세요."),
    DUPLICATE_NUMBER("당첨 번호와 중복 되지 않는 1~45사이의 수를 입력해 주세요."),
    END_WITH_NUMBER("6개의 숫자를 입력해 주세요."),
    INSUFFICIENT_LOTTO_NUMBER("당첨 번호 6개를 모두 입력해 주세요."),
    NOT_LOTTO_NUMBER("로또 번호는 1~45사이의 숫자만 가능 합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복 되지 않아야 합니다.");

    private String message;

    ErrorText(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
