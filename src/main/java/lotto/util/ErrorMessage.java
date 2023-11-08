package lotto.util;

public enum ErrorMessage {
    LOTTO_PRICE_MUST_UP_1000("[ERROR] 금액은 1000원 이상 이어야 합니다."),
    LOTTO_PRICE_MUST_MULTIPLY_1000("[ERROR] 금액은 1000원 단위로 입력 받아야 합니다."),
    LOTTO_PRICE_MUST_BE_INTEGER("[ERROR] 금액은 정수로 입력 받아야 합니다."),
    LOTTO_MUST_HAVE_SIX("[ERROR] 로또는 6개의 숫자를 가져야 합니다."),
    LOTTO_MUST_HAVE_NOT_DUPLICATED_NUMBER("[ERROR] 로또는 중복 되지 않는 숫자를 가져야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
