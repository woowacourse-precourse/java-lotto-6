package lotto.constant;

public enum ErrorMessage {
    INVALID_PURCHASE_PRICE("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다."),
    OUT_OF_BOUND_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않는 숫자여야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 한 로또 당 6개의 숫자까지 가능합니다.")
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return this.message;
    }
}
