package lotto.common.exception;

public enum ErrorType {
    INVALID_PURCHASE_AMOUNT("로또 구입 금액은 1,000원 단위이어야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호의 개수는 6개여야 합니다."),
    INVALID_NUMBERS("로또 번호와 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("로또 번호와 보너스 번호는 모두 서로 중복되지 않는 숫자여야 합니다."),
    ;

    final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
