package lotto.exception;

public enum LottoExceptionType {
    DUPLICATE_NUMBERS("중복된 로또 번호가 있습니다."),
    NUMBER_FORMAT_ERROR_MESSAGE("숫자가 아니면 입력할 수 없습니다."),
    INVALID_NUMBER_RANGE("은(는) 유효한 로또 번호 범위가 아닙니다."),
    MINIMUM_LOTTO_AMOUNT("로또 구입 최소 금액은 1,000원입니다."),
    MULTIPLE_OF_1000("로또 구입 금액은 1,000원의 배수여야 합니다."),
    INVALID_BONUS_NUMBER("로또 번호는 1~45 사이의 숫자여야 합니다."),
    UNDEFINED_LOTTO_INFO_MESSAGE("로또 정보가 존재하지 않습니다."),
    ERROR_PREFIX("[ERROR] ");


    private final String message;

    LottoExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
