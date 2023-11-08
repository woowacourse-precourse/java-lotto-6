package lotto.constant;

public enum ErrorMessage {
    INPUT_IS_EMPTY("공백은 입력될 수 없습니다."),
    PURCHASE_AMOUNT_IS_NOT_A_NUMBER("구입 금액은 숫자만 입력될 수 있습니다."),
    PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS("구입 금액의 단위는 1,000원 입니다."),
    PURCHASE_AMOUNT_IS_ZERO("구입 금액은 0원보다 커야 합니다."),
    LOTTO_WRONG_NUMBER_SIZE("로또 번호의 개수는 6개이어야 합니다."),
    LOTTO_NUMBER_IS_DUPLICATE("중복된 번호는 입력될 수 없습니다."),
    LOTTO_NUMBER_IS_OUT_OF_RANGE("로또 번호는 1 이상 45 이하의 정수만 가능합니다."),
    LOTTO_NUMBER_IS_NOT_NUMBER_OR_COMMA("당첨 번호는 쉼표로 구분되어야 하며, 숫자만 입력될 수 있습니다."),
    BONUS_NUMBER_IS_NO_NUMBER("보너스 번호는 숫자만 입력될 수 있습니다."),
    BONUS_NUMBER_IS_OUT_OF_RANGE("보너스 번호는 1 이상 45 이하의 정수만 가능합니다."),
    BONUS_NUMBER_CONTAIN_LOTTO("당첨 번호에 이미 포함 되어있는 숫자입니다.");

    private static final String ERROR_HEAD = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_HEAD + message;
    }

    public String getMessage() {
        return message;
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException(message);
    }

    public void throwNumberFormatException() {
        throw new NumberFormatException(message);
    }
}
