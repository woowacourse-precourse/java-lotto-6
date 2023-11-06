package lotto.domain.exception;

public enum LottoException {
    DUPLICATED_LOTTO_NUMBER("중복된 숫자는 입력이 불가능합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨번호와 중복될 수 없습니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개로 구성되어야 합니다."),
    INVALID_LOTTO_RANGE("로또번호는 1부터 45 사이에 있어야 합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    LottoException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }

}
