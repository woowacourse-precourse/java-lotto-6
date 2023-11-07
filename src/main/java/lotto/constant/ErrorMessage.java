package lotto.constant;

public enum ErrorMessage {
    PRICE_IS_NOT_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    WINNING_NUMBER_IS_NOT_NUMBER("[ERROR] 당첨 번호는 숫자만 입력 가능합니다."),
    BONUS_NUMBER_IS_NOT_NUMBER("[ERROR] 보너스 번호는 숫자만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_SIZE("[ERROR] 로또 번호는 6개만 가능합니다."),
    LOTTO_NUMBER_DUPLICATED("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
