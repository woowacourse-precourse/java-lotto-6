package lotto.exception;

public enum LottoErrorMessage {
    LOTTO_SIZE_ERROR("로또 번호는 6개만 입력 가능합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다."),
    LOTTO_NUMBER_FORMAT_ERROR("로또 번호는 숫자만 가능합니다.");

    private final String message;
    private final String ERROR = "[ERROR] ";

    LottoErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
