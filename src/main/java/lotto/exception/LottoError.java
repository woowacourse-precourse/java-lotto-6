package lotto.exception;

public enum LottoError {
    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND("로또 구매 금액은 1000원 단위의 양수여야 합니다."),
    INVALID_NUMBER("숫자가 아닌 값이 입력되었습니다.");

    private final String message;

    LottoError(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + this.message;
    }
}
