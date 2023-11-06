package lotto.exception;

public enum ExceptionMessage {
    NOT_MUST_BE_NULL("입력값은 null일 수 없습니다."),
    MUST_BE_DIGIT("숫자만 입력 가능합니다."),
    MUST_BE_WINNING_LOTTO("당첨 로또가 존재하지 않습니다."),
    DUPLICATE_BONUS_NUMBER("로또 번호와 보너스 번호는 중복될 수 없습니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복이 있을수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format(final Object... args) {
        return String.format(message, args);
    }
}
