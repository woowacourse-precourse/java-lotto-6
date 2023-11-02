package lotto.exception;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    LOTTO_SIZE("로또 번호의 개수는 6개여야만 합니다."),
    LOTTO_DUPLICATE("로또 번호는 중복된 숫자를 고를 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String printMessage() {
        return this.message;
    }
}
