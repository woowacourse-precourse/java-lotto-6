package lotto.exception;

public enum ErrorMessage {
    NUMBER_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBER_RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    MINIMUM_PRICE("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다."),
    PRICE_UNIT("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다."),
    NUMBER_TYPE("[ERROR] 로또 번호는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
