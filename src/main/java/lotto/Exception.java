package lotto;

public enum Exception {
    // 구입 금액
    ONLY_DIVISIBLE_BY_THOUSAND("구입 금액은 1000원 단위로 입력해주세요."),
    ONLY_NUMERIC_INPUT_FOR_MONEY("구입금액은 숫자만 입력 가능합니다."),

    // 당첨 번호
    INVALID_WINNING_NUMBERS_INPUT_TYPE("당첨 번호는 숫자만 가능합니다."),
    WINNING_NUMBERS_SIZE_SHOULD_BE_SIX("당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER_RANGE("당첨 번호는 1과 45 사이에 있는 수만 가능합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다."),

    // 보너스 번호
    INVALID_BONUS_NUMBER_INPUT_TYPE("보너스 번호는 숫자만 가능합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    ;
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
