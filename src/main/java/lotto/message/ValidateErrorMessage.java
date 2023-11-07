package lotto.message;

public enum ValidateErrorMessage {

    PAYMENT_ERROR("구입 금액은 1,000원 단위 정수여야 합니다."),
    LOTTO_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_SIZE_ERROR("로또 번호는 6개 숫자여야 합니다."),
    LOTTO_SAME_NUMBER_ERROR("로또 번호는 서로 다른 숫자여야 합니다.");

    private final String message;

    ValidateErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
