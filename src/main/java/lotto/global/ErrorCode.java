package lotto.global;

public enum ErrorCode {
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호가 범위를 벗어났습니다."),
    LOTTO_NUMBER_COUNT_INCORRECT("로또 번호의 개수가 다릅니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호가 중복되었습니다."),

    INVALID_INPUT_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원 단위의 숫자여야 합니다."),
    INVALID_INPUT_LOTTO_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
