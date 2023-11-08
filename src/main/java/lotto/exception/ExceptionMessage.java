package lotto.exception;

public enum ExceptionMessage {
    INPUT_BLANK("[ERROR] 입력값이 빈 문자열 또는 공백입니다."),
    INPUT_NUMBER_FORMAT("[ERROR] 숫자만 입력해주세요."),
    INVALID_PRICE_RANGE("[ERROR] 최소 %d원, 최대 %d원까지 구매 가능합니다."),
    NON_DIVISIBLE_AMOUNT("[ERROR] 금액이 나누어 떨어지지 않습니다."),
    NEGATIVE_AMOUNT("[ERROR] 금액은 음수가 될 수 없습니다."),
    LOTTO_NUMBERS_LENGTH("[ERROR] 로또는 6개의 번호로 구성되어야 합니다."),
    LOTTO_NUMBERS_DUPLICATED("[ERROR] 중복된 번호가 존재합니다."),
    LOTTO_NUMBER_RANGE("[ERROR] %d과 %d사이의 숫자만 번호로 등록 가능 합니다.");
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
