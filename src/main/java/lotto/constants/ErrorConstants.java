package lotto.constants;

public enum ErrorConstants {
    PLEASE_ENTER_VALUE("값을 입력해 주세요."),
    ONLY_ENTER_NUMBERS("숫자만 입력하실 수 있습니다."),
    INVALID_RANGE_INPUT("%d 이상의 구매 금액을 입력해 주세요."),
    INVALID_UNIT_INPUT("%d 원 단위의 구매 금액을 입력해 주세요."),
    ERROR_LOTTO_INVALID_LENGTH("로또 발행 중 에러발생. 6자리가 아닙니다."),
    ERROR_LOTTO_INVALID_RANGE("로또 발행 중 에러발생. 유효하지 않은 범위의 숫자입니다."),
    ERROR_LOTTO_DUPLICATED_VALUE("로또 발행 중 에러발생. 중복된 값이 존재합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String ErrorConstants;

    ErrorConstants(String errorConstants) {
        this.ErrorConstants = ERROR_TAG + errorConstants;
    }
    public String getData() {
        return ErrorConstants;
    }

}
