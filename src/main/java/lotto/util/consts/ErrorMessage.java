package lotto.util.consts;

public enum ErrorMessage {
    NOT_NUMBER_INPUTTED("구입할 금액은 숫자로 입력해야합니다."),
    TOO_LARGE_NUMBER("입력한 숫자가 너무 큽니다."),
    MINUS_MONEY("금액은 양수여야합니다."),
    NOT_DIVIDED_BY_LOTTO_PRICE("1,000원으로 나누어떨어지는 금액만 입력 가능합니다."),
    OUT_OF_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBERS("로또 번호는 중복되면 안됩니다."),
    UNCORRECT_LOTTO_NUMBER_SIZE("로또 번호는 6자리여야합니다."),
    OUT_OF_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 로또 번호와 중복되지 않아야합니다."),
    EMPTY_LOTTO_NUMBERS("로또 번호가 공백입니다. 입력 오류"),
    NULL_LOTTO_NUMBERS("로또 번호가 전달되지 않았습니다. (null)");

    private static final String ERROR_CODE = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_CODE + message;
    }
}
