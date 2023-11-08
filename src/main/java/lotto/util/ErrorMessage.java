package lotto.util;

public enum ErrorMessage {
    LOTTO_PRICE_MUST_UP_1000("[ERROR] 금액은 1000원 이상 이어야 합니다."),
    LOTTO_PRICE_MUST_MULTIPLY_1000("[ERROR] 금액은 1000원 단위로 입력 받아야 합니다."),
    LOTTO_PRICE_MUST_BE_INTEGER("[ERROR] 금액은 정수로 입력 받아야 합니다."),
    LOTTO_MUST_HAVE_SIX("[ERROR] 로또는 6개의 숫자를 가져야 합니다."),
    LOTTO_MUST_HAVE_NOT_DUPLICATED_NUMBER("[ERROR] 로또는 중복 되지 않는 숫자를 가져야 합니다."),
    LOTTO_MUST_HAVE_BETWEEN_1_AND_45("[ERROR] 로또는 1 이상 45 이하의 숫자이어야 합니다."),

    WRONG_WINNING_NUMBER_COUNT("[ERROR] 당첨 번호는 6개 입력이 필요합니다."),
    WRONG_WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호 입력 형식이 올바르지 않습니다. (숫자 6개로 구성되어야 합니다.)"),

    WRONG_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호 입력 형식이 올바르지 않습니다. (정수 형식이 아닙니다.)"),
    WRONG_BONUS_NUMBER_RANGE("[ERROR]  보너스 번호 입력 형식이 올바르지 않습니다. (올바른 숫자 범위가 아닙니다.)"),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
