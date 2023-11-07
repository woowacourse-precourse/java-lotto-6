package lotto.constants;

public enum ExceptionMessage {
    LOTTO_ERROR("[ERROR] 로또 숫자는 1~45사이의 중복되지 않은 6개의 숫자로 이루어져야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
