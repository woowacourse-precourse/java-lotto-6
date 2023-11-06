package lotto.constants;

public enum ErrorMessage {

    NOT_INTEGER_INPUT("[ERROR] 정수만 입력 가능합니다."),
    CONTAINS_BLANK_INPUT("[ERROR] 공백이 포함되어 있습니다."),
    INVALID_LOTTO_NUMBERS_SIZE("[ERROR] 로또 번호는 %d개여야 한다."),
    INVALID_LOTTO_NUMBERS_RANGE("[ERROR] 로또 번호는 %d이상 %d이하여야 한다."),
    DUPLICATED_LOTTO_NUMBER("[ERROR] 로또 번호는 서로 달라야 한다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위어야 합니다."),
    INVALID_PURCHASE_AMOUNT_RANGE("[ERROR] 구입 금액은 %,d원 이상 %,d원 이하여야 합니다."),
    INVALID_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 %d개여야 한다."),
    INVALID_WINNING_NUMBERS_RANGE("[ERROR] 당첨 번호는 %d이상 %d이하여야 한다."),
    DUPLICATED_WINNING_NUMBER("[ERROR] 당첨 번호는 서로 달라야 한다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 %d이상 %d이하여야 한다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
