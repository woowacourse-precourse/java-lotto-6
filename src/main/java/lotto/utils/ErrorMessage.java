package lotto.utils;

public enum ErrorMessage {
    USER_INSERT_ONLY_NUMBER("[ERROR] 숫자만 입력 가능합니다"),
    LOTTO_NUMBER_SIZE_RANGE_ERROR("[ERROR] 로또 번호의 범위는 1-45 입니다"),
    LOTTO_NUMBER_NOT_DUPLICATE("[ERROR] 로또 번호는 중복 될수 없습니다"),
    LOTTO_NUMBER_NOT_SIX_SIZE("[ERROR] 로또 번호는 6자리 입니다"),
    LOTTO_NUMBER_BONUS_NUMBER_NOT_DUPLICATE("[ERROR] 보너스는 로또 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_RANGE_ERROR("[ERROR] 보너스 숫자의 범위는 1-45까지 입니다 ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
