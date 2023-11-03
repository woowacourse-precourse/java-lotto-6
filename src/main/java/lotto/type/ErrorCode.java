package lotto.type;

public enum ErrorCode {
    INVALID_MONEY_TO_BUY("[ERROR] 구입 금액은 1,000원 단위만 가능 합니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자만 가능합니다.");

    private final String description;

    ErrorCode(String message) {
        this.description = message;
    }

    public String getDescription() {
        return description;
    }
}
