package lotto.exception;

public enum ErrorMessage {

    // Validator
    PURCHASE_AMOUNT_UNDER_THOUSAND("구입 금액은 1000원 이상이어야 합니다."),
    INDIVISIBLE_PURCHASE_AMOUNT("구입 금액은 1000원으로 나누어떨어져야 합니다."),
    NOT_EMPTY_OR_BLANK("공백이 존재하거나 값이 비어있으면 안됩니다."),
    NOT_EXIST_CHARACTER("문자가 존재하면 안됩니다."),
    DUPLICATE_WITH_WIN_NUMBER("당첨 숫자와 중복되지 않아야 합니다."),

    // Lotto
    INVALID_LOTTO_NUMBER_COUNT("로또 번호의 갯수는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
