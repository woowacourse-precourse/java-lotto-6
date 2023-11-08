package lotto.util;

public enum ErrorCode {
    INVALID_INTEGER_FORMAT("[ERROR] 정수 형식에 맞지 않는 입력 입니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또번호는 1~45사이의 정수로만 이루어져야 합니다."),
    INVALID_NUMBER_SIZE("[ERROR] 번호의 개수는 6개 이어야 합니다."),
    INVALID_CASH_AMOUNT("[ERROR] 구입금액은 최소 1000원 입니다."),
    INVALID_CASH_UNIT("[ERROR] 구입금액은 1000원 단위 입니다."),
    REDUNDANT_NUMBER("[ERROR] 로또번호가 중복 되어서는 안됩니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}