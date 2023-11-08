package lotto.exception;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    EMPTY_PURCHASE_AMOUNT("구매 금액이 입력되지 않았습니다."),
    INVALID_PURCHASE_AMOUNT("구매 금액이 잘못 입력되었습니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호가 중복되었습니다."),
    INVALID_LOTTO_SIZE("로또 번호의 개수가 6개가 아닙니다"),
    INVALID_NUMBER_RANGE("올바른 로또 번호가 아닙니다."),
    EMPTY_WINNING_NUMBER("입력되지 않은 당첨번호가 있습니다."),
    INVALID_WINNING_NUMBERS_SIZE("당첨 번호의 개수가 잘못 입력되었습니다."),
    INVALID_WINNING_NUMBERS_RANGE("올바르지 않은 당첨 번호가 존재합니다."),
    INVALID_BONUS_NUMBER_RANGE("올바른 보너스 번호가 아닙니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호가 중복되었습니다."),
    EMPTY_BONUS_NUMBER("보너스 넘버가 입력되지 않았습니다."),
    INVALID_INTEGER_FORMAT("입력된 문자가 정수로 변환되지 않습니다."),
    INVALID_PRIZE_COUNT("잘못된 당첨 개수 입니다."),
    ;

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR.errorMessage + errorMessage;
    }
}
