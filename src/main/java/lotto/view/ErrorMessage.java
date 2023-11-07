package lotto.view;

public enum ErrorMessage {
    DUPLICATED_LOTTO("로또 번호에 중복이 있습니다"),
    INVALID_LOTTO_LENGTH("로또 번호의 개수가 맞지 않습니다"),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호의 범위가 맞지 않습니다"),
    NOT_ENOUGH_PURCHASE_AMOUNT("로또를 구입하기에 부족한 금액입니다"),
    INVALID_PURCHASE_AMOUNT("금액은 로또 가격의 배수로 입력해야 합니다"),
    INVALID_TYPE("잘못된 타입입니다"),
    BONUS_NUMBER_CONFLICT("보너스 번호가 당첨 번호와 중복됩니다"),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final String message;

    public String getErrorMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
