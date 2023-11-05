package lotto.view;

public enum ExceptionMessage {
    RANGE_EXCEPTION("[ERROR] 숫자는 1부터 45 사이의 숫자여야 합니다."),
    SIZE_EXCEPTION("[ERROR] 당첨 번호는 6개 입력 가능합니다."),
    OVERLAP_EXCEPTION("[ERROR] 중복된 숫자를 입력하셨습니다."),
    TYPE_EXCEPTION("[ERROR] 숫자만 입력해 주세요."),
    NUMBER_EXCEPTION("[ERROR] 금액은 숫자만 등록 가능합니다."),
    NATURAL_EXCEPTION("[ERROR] 금액은 0 초과이어야 합니다."),
    DIVISIBLE_EXCEPTION("[ERROR] 금액은 1000단위여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
