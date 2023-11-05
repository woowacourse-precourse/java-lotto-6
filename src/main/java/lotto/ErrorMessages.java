package lotto;

public enum ErrorMessages {
    PAYMENT_ERROR_MESSAGE("[ERROR]1000원 단위로만 입력 가능합니다."),
    LOTTO_ERROR_MESSAGE("[ERROR]1~45 사이의 6개의 숫자만 입력 가능하며, 중복은 허용되지 않습니다."),
    BONUS_NUMBER_ERROR_MESSAGE("[ERROR]1~45 사이의 로또 번호와 중복되지 않는 숫자만 입력 가능합니다.");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}