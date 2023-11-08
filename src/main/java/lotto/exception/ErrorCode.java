package lotto.exception;

public enum ErrorCode {
    MISSING_BONUS_NUMBER("[ERROR] 보너스 번호는 공백일 수 없습니다.\n"),
    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 넘버는 숫자만 입력할 수 있습니다.\n"),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 넘버는 1~45 사이의 숫자만 입력할 수 있습니다.\n"),
    MISSING_PURCHASE_AMOUNT("[ERROR] 구입 금액은 공백일 수 없습니다.\n"),
    INVALID_PURCHASE_AMOUNT_FORMAT("[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.\n"),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 천원 단위로 입력할 수 있습니다.\n"),
    MISSING_WINNING_NUMBERS("[ERROR] 당첨 번호는 공백일 수 없습니다.\n"),
    INVALID_WINNING_NUMBERS_FORMAT("[ERROR] 당첨 번호는 숫자와 ,(쉼표)로만 입력할 수 있습니다.\n"),
    INVALID_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 6개의 숫자로 입력할 수 있습니다.\n"),
    DUPLICATE_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1~45 사이에 숫자만 입력할 수 있습니다.\n"),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
