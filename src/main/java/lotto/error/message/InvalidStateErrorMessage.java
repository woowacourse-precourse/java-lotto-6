package lotto.error.message;

public enum InvalidStateErrorMessage implements ErrorMessage {
    LOTTO_NUMBERS_COUNT_NOT_SIX("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("6개의 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    InvalidStateErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
