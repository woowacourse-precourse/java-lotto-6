package lotto.exception;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    LOTTO_SIZE("로또 번호의 개수는 6개여야만 합니다."),
    LOTTO_DUPLICATE("로또 번호는 중복된 숫자를 고를 수 없습니다."),
    MONEY_RANGE("최소 1000원부터 최대 100,000원까지의 금액을 입력해주세요."),
    MONEY_UNIT("구입 금액은 1000원 단위여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
