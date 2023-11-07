package lotto.Constant;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    INVALID_AMOUNT("구매 금액은 숫자여야 합니다."),
    INVALID_MIN_AMOUNT("구매 금액은 %d원 이상이어야 합니다."),
    INVALID_UNIT_AMOUNT("구매 금액은 %d원 단위여야 합니다."),
    INVALID_MAX_AMOUNT("구매 금액은 %d원을 초과할 수 없습니다."),
    INVALID_FORMAT("입력 형식이 잘못되었습니다. 숫자는 쉼표로 구분하여 입력해야 합니다."),
    INVALID_RANGE("번호는 %d부터 %d 사이여야 합니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다."),
    INCORRECT_NUMBER_COUNT("번호를 %d개 입력하세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message + message;
    }

    public String getMessage(int amount) {
        return ERROR.message + String.format(message, amount);
    }

    public String getMessage(int startInclusive, int endInclusive) {
        return ERROR.message + String.format(message, startInclusive, endInclusive);
    }

}