package lotto.exception;

public enum ErrorMessage {
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호의 개수는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATED("[ERROR] 로또 번호에는 중복이 없어야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_PAYMENT_RANGE("[ERROR] 구입금액은 로또 개당 가격 이상이어야 합니다."),
    INVALID_PAYMENT_FORM("[ERROR] 구입금액은 로또 개당 가격으로 나누어 떨어져야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
