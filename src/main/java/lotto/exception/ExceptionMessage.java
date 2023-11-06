package lotto.exception;

public enum ExceptionMessage {
    INPUT_BLANK("[ERROR] 입력값이 빈 문자열 또는 공백입니다.\n"),
    INPUT_NUMBER_FORMAT("[ERROR] 숫자만 입력해주세요.\n"),
    INVALID_PRICE_RANGE("[ERROR] 최소 %d원, 최대 %d원까지 구매 가능합니다.\n"),
    NON_DIVISIBLE_AMOUNT("[ERROR] 금액이 나누어 떨어지지 않습니다.\n"),
    NEGATIVE_AMOUNT("[ERROR]금액은 음수가 될 수 없습니다.\n");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public GameException getException() {
        return new GameException(this.message);
    }

    public GameException getException(int min, int max) {
        return new GameException(String.format(this.message, min, max));
    }
}
