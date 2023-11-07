package lotto.util;

public enum ErrorMessage {
    LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 반드시 6개여야 합니다."),
    LOTTO_NUMBER_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_UNIQUE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_COUNT("[ERROR] 당첨 번호는 반드시 6개여야 합니다."),
    WINNING_NUMBER_IN_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_NUMBER_UNIQUE("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    INVALID_INPUT_WINNING_NUMBER("[ERROR] 유효하지 않은 당첨 번호입니다."),
    INVALID_INPUT_PURCHASE_AMOUNT("[ERROR] 유효하지 않은 금액입니다."),
    INVALID_AMOUNT_MULTIPLE_OF_THOUSAND("[ERROR] 구입 금액은 1,000원 단위로 입력할 수 있습니다."),
    INVALID_AMOUNT_GREATER_THAN_MAXIMUM("[ERROR] 구입 금액은 최대 10만원까지 가능합니다."),
    INVALID_AMOUNT_LESS_THAN_MINIMUM("[ERROR] 구입 금액은 최소 1,000원부터 가능합니다."),
    INVALID_INPUT_BONUS_NUMBER("[ERROR] 유효하지 않은 보너스 번호입니다."),
    INVALID_BONUS_NUMBER_IN_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_UNIQUE("[ERROR] 보너스 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_NOT_SET("[ERROR] 보너스 번호가 설정되지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
