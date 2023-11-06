package lotto;

public enum Exception {
    ONLY_DIVISIBLE_BY_THOUSAND("구입 금액은 1000원 단위로 입력해주세요."),
    ONLY_NUMERIC_INPUT_FOR_MONEY("구입금액은 숫자만 입력 가능합니다."),
    INVALID_WINNING_NUMBERS_INPUT_TYPE("당첨 번호는 숫자만 가능합니다."),
    WINNING_NUMBERS_SIZE_SHOULD_BE_SIX("당첨 번호는 6개여야 합니다.");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
