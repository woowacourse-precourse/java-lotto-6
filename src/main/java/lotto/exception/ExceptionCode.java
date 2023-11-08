package lotto.exception;

public enum ExceptionCode {
    NUMBER_FORMAT("[ERROR] 숫자 형식으로 입력해주세요."),
    LOTTO_INVALID_SIZE("[ERROR] 로또 번호가 6자리가 되도록 입력해주세요."),
    LOTTO_INVALID_RANGE("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요."),
    LOTTO_DUPLICATION("[ERROR] 로또 번호가 중복되지 않도록 입력해주세요."),
    AMOUNT_PURCHASE_PRICE("[ERROR] 구매 금액을 1,000원 단위로 입력해주세요."),
    UNSIGNED_PURCHASE_PRICE("[ERROR] 구매 금액을 양수로 입력해주세요.");

    private final String description;

    ExceptionCode(final String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
