package lotto.exception;

public enum ErrorCode {
    INVALID_WINNING_NUMBER_LENGTH("당첨 번호는 6개여야 합니다."),
    OUT_OF_RANGE_WINNING_NUMBERS("당첨 번호들과 보너스 번호는 1~45 사이여야 합니다."),
    DUPLICATED_WINNING_NUMBERS("당첨 번호들과 보너스 번호는 중복될 수 없습니다."),
    NON_INT_PURCHASE_AMOUNT("구입금액은 정수로 입력해야 합니다."),
    NON_INT_MAIN_WINNING_NUMBERS("당첨 번호는 쉼표로 구분된 정수들로 입력해야 합니다."),
    NON_INT_BONUS_NUMBER("보너스 번호는 정수로 입력해야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
