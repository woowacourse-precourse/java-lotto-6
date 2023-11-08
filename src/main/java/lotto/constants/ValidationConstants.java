package lotto.constants;

public enum ValidationConstants {
    ERROR_NOT_A_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    ERROR_NEGATIVE_NUMBER("음수가 입력되었습니다."),
    ERROR_INVALID_LOTTO_NUMBER_COUNT("로또 번호의 개수가 6개가 아닙니다."),
    ERROR_OUT_OF_RANGE_LOTTO_NUMBER("로또 번호 중 범위를 벗어나는 값이 있습니다."),
    ERROR_DUPLICATE_LOTTO_NUMBER("중복된 번호가 입력 되었습니다."),
    ERROR_INVALID_PURCHASE_AMOUNT("금액이 천원 단위가 아닙니다.");

    private final String message;

    ValidationConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
