package lotto.domain;

public enum ExceptionMessage {
    LOTTO_WRONG_SIZE("로또 번호는 6개의 정수여야 합니다."),
    LOTTO_NOT_INTEGER("로또 번호는 정수여야 합니다."),
    LOTTO_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE_NUMBERS("로또 번호는 서로 다른 수여야 합니다."),
    AMOUNT_NOT_INTEGER("구입금액은 정수여야 합니다."),
    AMOUNT_NOT_POSITIVE("구입금액은 양수여야 합니다."),
    AMOUNT_NOT_DIVIDED_BY_PRICE("구입금액은 1000원 단위로 나누어떨어져야 합니다.");

    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
