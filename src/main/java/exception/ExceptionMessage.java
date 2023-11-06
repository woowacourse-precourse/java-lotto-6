package exception;

public enum ExceptionMessage {
    INVALID_MONEY_RANGE_MESSAGE("[ERROR] 로또 구입 금액은 1,000원 이상 1,000,000,000원 이하여야 합니다."),
    INVALID_MONEY_ARGUMENT_MESSAGE("[ERROR] 로또 구입 금액은 숫자로만 구성되어야 합니다."),
    MONEY_NOT_BEING_DEVIDED_BY_THOUSAND_MESSAGE("[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다."),
    INVALID_WINNING_NUMBER_ARGUMENT_MESSAGE("[ERROR] 당첨 번호는 숫자로만 이루어져 있어야 합니다."),
    INVALID_WINNING_NUMBER_RANGE_MESSAGE("[ERROR] 당첨 번호는 1 이상 45 이하여야 합니다."),
    INVALID_WINNING_NUMBER_INPUT_FORMAT_MESSAGE("[ERROR] 당첨 번호는 쉼표로 구분하여 6개 입력해야 합니다."),
    INVALID_WINNING_NUMBER_DUPLICATION_MESSAGE("[ERROR] 당첨 번호에 중복된 숫자가 입력되어서는 안됩니다."),
    INVALID_BONUS_NUMBER_ARGUMENT_MESSAGE("[ERROR] 보너스 번호는 숫자로만 이루어져 있어야 합니다."),
    INVALID_BONUS_NUMBER_RANGE_MESSAGE("[ERROR] 보너스 번호는 1 이상 45 이하여야 합니다."),
    INVALID_INPUT_MESSAGE("[ERROR] 올바른 입력이 아닙니다.");

    private String message;

    ExceptionMessage (String message) {
        this.message = message;
    }

    String getMessage(String message) {
        return message;
    }
}
