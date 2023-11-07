package lotto.domain;

public enum LottoExceptionType {
    WRONG_SIZE("로또 번호는 6개의 정수여야 합니다."),
    NOT_INTEGER("로또 번호는 정수여야 합니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("로또 번호는 서로 다른 수여야 합니다."),
    INCLUDED_IN_WINNING_LOTTO("보너스 번호는 당첨 번호와 다른 수여야 합니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    private final String message;

    private LottoExceptionType(String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
