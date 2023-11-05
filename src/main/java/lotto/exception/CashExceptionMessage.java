package lotto.exception;

public enum CashExceptionMessage {
    NOT_MORE_THAN_UNIT("[ERROR] 1,000원 이상의 금액을 입력하셔야 합니다."),
    NOT_DIVISIBLE_BY_UNIT("[ERROR] 1,000원으로 나누어 떨어지는 금액을 입력하셔야 합니다.");
    private final String message;

    CashExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
