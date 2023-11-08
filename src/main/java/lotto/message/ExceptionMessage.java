package lotto.message;

public enum ExceptionMessage {
    INVALID_PURCHASE_AMOUNT("구입 금액은 1,000원 단위만 가능합니다."),
    INVALID_SIZE("로또 번호는 6개의 숫자만 가능합니다."),
    INVALID_UNIQUE("로또 번호는 중복되지 않는 숫자만 가능합니다."),
    INVALID_RANGE("로또 번호의 숫자 범위는 1~45까지만 가능합니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format("[ERROR] %s", message);
    }

    public String getMessage() {
        return message;
    }
}
