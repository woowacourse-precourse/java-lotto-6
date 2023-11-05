package lotto.domain.constant;

public enum ErrorMessages {
    NOT_INTEGER("[ERROR] 정수가 아닙니다."),
    PURCHASE_RANGE("[ERROR] 로또는 최소 한 개 최대 천 개까지 구입 가능합니다."),
    PURCHASE_UNIT("[ERROR] 구입 금액은 1000단위 숫자이어야 합니다."),
    NOT_UNIQUE("[ERROR] 중복이 발생합니다."),
    RANGE_NUMBER("[ERROR] 1이상 45이하의 숫자여야 합니다."),
    NUMBER_OF_LOTTO("[ERROR] 로또는 6개 숫자여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
