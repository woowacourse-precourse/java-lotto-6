package lotto.exception.constant;

public enum ErrorMessage {
    INVALID_PRICE_TYPE("숫자가 아닙니다."),
    INVALID_INPUT("입력이 올바르지 않습니다."),
    EMPTY("공백은 입력할 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("번호는 1~45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    INVALID_LOTTO_LENGTH("입력한 로또의 길이가 올바르지 않습니다."),
    INVALID_LOTTO_FORMAT("로또 번호의 형식이 올바르지 않습니다."),
    INVALID_INPUT_PRICE("금액의 형식이 올바르지 않습니다."),
    INVALID_PRICE_RANGE("입력한 금액의 범위가 올바르지 않습니다.");
    private final String prefix = "[ERROR] ";
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getErrorMessage() {
        return prefix + message;
    }
}
