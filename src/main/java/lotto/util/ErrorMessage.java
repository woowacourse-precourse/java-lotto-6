package lotto.util;

public enum ErrorMessage {
    INVALID_INTEGER_FORMAT("[ERROR] INTEGER 형식에 어긋나는 입력입니다."),
    INVALID_INTEGER_LIST_FORMAT("[ERROR] INTEGER LIST 형식에 어긋나는 입력입니다."),
    INVALID_NUMBER("[ERROR] 번호는 1과 45 사이의 숫자 이어야 합니다."),
    INVALID_NUMBER_SIZE("[ERROR] 번호의 개수는 6개 이어야 합니다."),
    INVALID_PAYMENT_AMOUNT("[ERROR] 구입금액은 1000원 단위이어야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복되는 번호가 존재합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
