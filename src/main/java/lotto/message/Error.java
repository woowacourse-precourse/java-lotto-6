package lotto.message;

public enum Error {
    POSITIVE_INTEGER("[ERROR] 양의 정수만 입력해야 합니다."),
    THOUSAND_UNITS("[ERROR] 1,000 단위로 입력해야 합니다."),
    MAX_PURCHASE_LIMIT("[ERROR] 10만원을 초과해서 구매할 수 없습니다."),

    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 중복된 숫자를 입력할 수 없습니다."),
    LOTTO_MORE_THAN_SIX_NUMBER("[ERROR] 6개를 초과하는 숫자를 입력할 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
