package lotto.constant;

public enum ErrorMessages {
    PREFIX("[ERROR] "),
    SUFFIX(" 다시 입력해 주세요"),
    INVALID_COUNT("입력하신 번호의 개수가 잘못되었습니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다."),
    NEGATIVE_AMOUNT("0원 이하는 입력이 불가능합니다."),
    ILLEGAL_AMOUNT("백만원 이상은 구매하실 수 없습니다."),
    INVALID_RANGE("입력 가능한 번호의 범위는 %d부터 %d까지 입니다."),
    INVALID_TYPE("번호는 숫자만 입력 가능합니다."),
    INVALID_AMOUNT("금액은 %,d원 단위로 입력해주시기 바랍니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
