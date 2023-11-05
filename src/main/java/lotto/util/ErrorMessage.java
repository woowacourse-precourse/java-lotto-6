package lotto.util;

public enum ErrorMessage {
    ILLEGAL_ARGUMENT_MONEY("금액은 1,000으로 나누어 떨어지는 자연수여야 합니다."),
    ILLEGAL_ARGUMENT_NUMBERS_FORMAT("로또 번호는 ,로 구분된 6개의 1부터 45 사이 숫자여야 합니다."),
    ILLEGAL_ARGUMENT_BONUS_NUMBER("보너스 번호는 1부터 45 사이 숫자여야 합니다."),
    ILLEGAL_ARGUMENT_WIN_LOTTO("입력 받은 로또 번호와 보너스 번호는 중복되지 않아야 합니다.");

    private final String message;
    private static final String prefix = "[ERROR] ";
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
