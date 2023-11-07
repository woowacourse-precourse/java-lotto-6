package lotto.enumeration;

public enum ExceptionType {
    INVALID_AMOUNT_TYPE("[ERROR] 구입금액은 숫자여야 합니다."),
    EXCEED_AMOUNT_LIMIT("[ERROR] 구입금액은 최소 1,000원, 최대 2,000,000,000원입니다."),
    AMOUNT_NOT_MULTIPLE_1000("[ERROR] 구입금액은 1,000원 단위여야 합니다.");

    private String message;
    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
