package lotto.view;

public enum ExceptionMessage {
    NULL_EXCEPTION("[ERROR] 값을 입력하세요."),
    RANGE_EXCEPTION("[ERROR] 숫자는 1부터 45 사이의 숫자여야 합니다."),
    SIZE_EXCEPTION("[ERROR] 번호는 6개 입력 가능합니다."),
    OVERLAP_EXCEPTION("[ERROR] 중복된 숫자를 입력하셨습니다. 다른 숫자를 입력하세요."),
    TYPE_EXCEPTION("[ERROR] 숫자만 입력해 주세요."),
    NATURAL_EXCEPTION("[ERROR] 금액은 0 초과이어야 합니다."),
    NUMBER_AND_COMMA_FORMAT_EXCEPTION("[ERROR] 당첨 번호는 숫자와 콤마 형식이어야 합니다."),
    DIVISIBLE_EXCEPTION("[ERROR] 금액은 1000 단위여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
