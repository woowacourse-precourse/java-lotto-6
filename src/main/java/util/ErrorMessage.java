package util;

public enum ErrorMessage {
    ONLY_INPUT_NUMBER("[ERROR] 숫자만 입력해 주세요"),
    AMOUNT_MUST_BE_DIVIDED_BY_PRICE("[ERROR] 금액은 1000단위 여야 합니다."),
    AMOUNT_MUST_POSITIVE("[ERROR] 금액은 양수 여야 합니다."),
    LOTTO_TAKE_SIX_NUMBERS("[ERROR] 로또는 6개의 번호를 가져야 합니다."),
    LOTTO_NUMBER_IS_UNIQUE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1 ~ 45 의 숫자 입니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
