package lotto.domain.message;

public enum ErrorMessage {
    INVALID_MONEY_VALUE("[ERROR] 금액은 1000원 단위의 금액이어야 합니다."),
    INVALID_LOTTO_LENGTH("[ERROR] 로또 번호의 길이는 6개여야 합니다."),
    DUPLICATES_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복을 허용하지 않습니다."),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."),
    DUPLICATES_BONUS_NUMBER("[ERROR] 당첨 번호와 중복된 보너스 번호를 입력할 수 없습니다."),
    NOT_FOUND_LOTTO("[ERROR] 로또 번호가 존재하지 않습니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력해야 합니다.");
    private final String value;

    ErrorMessage(final String value) {
        this.value = value;
    }

    public IllegalArgumentException createException() {
        return new IllegalArgumentException(value);
    }

    public String value() {
        return value;
    }
}
