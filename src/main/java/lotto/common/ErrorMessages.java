package lotto.common;

public enum ErrorMessages {
    NULL_OR_EMPTY("입력된 값이 공백이거나 null입니다."),
    NOT_A_NUMBER("입력된 값은 숫자가 아닙니다."),
    NOT_IN_1000_UNIT("1,000원 단위로 입력되어야 합니다."),
    BONUS_DUPLICATE_MESSAGE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_MESSAGE("당첨 번호에는 숫자와 쉼표(,)만 입력해야 합니다."),
    INVALID_NUMBERS_COUNT_MESSAGE("숫자는 6개여야 합니다."),
    DUPLICATE_NUMBERS_MESSAGE("숫자는 중복되면 안 됩니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
