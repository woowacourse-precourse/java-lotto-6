package lotto.constants;

public enum ErrorConstants {
    PLEASE_ENTER_VALUE("값을 입력해 주세요."),
    ONLY_ENTER_NUMBERS("숫자만 입력하실 수 있습니다."),
    INVALID_RANGE_INPUT("%d 이상의 구매 금액을 입력해 주세요."),
    INVALID_UNIT_INPUT("%d 원 단위의 구매 금액을 입력해 주세요."),
    ERROR_LOTTO_INVALID_LENGTH("로또 발행 중 에러발생. 6자리가 아닙니다."),
    ERROR_LOTTO_INVALID_RANGE("로또 발행 중 에러발생. 유효하지 않은 범위의 숫자입니다."),
    ERROR_LOTTO_DUPLICATED_VALUE("로또 발행 중 에러발생. 중복된 값이 존재합니다."),
    INVALID_WINNING_NUMERIC("로또 번호는 (,) 구분자와 숫자만 입력하실 수 있습니다."),
    INVALID_WINNING_LENGTH("6자리로 입력해 주세요."),
    INVALID_WINNING_RANGE("유효하지 않은 범위의 로또 번호가 존재합니다. 1~45 사이의 값을 입력해주세요"),
    INVALID_WINNING_DUPLICATE("로또 번호에 중복된 값이 존재합니다. 로또 번호는 중복할 수 없습니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1~45 사이의 숫자만 입력하실 수 있습니다."),
    MAXIMUM_NUMBER_OF_ATTEMPTS_EXCEEDED("최대 시도 횟수를 초과했습니다. 시스템을 종료합니다.");


    private static final String ERROR_TAG = "[ERROR] ";
    private final String ErrorConstants;

    ErrorConstants(String errorConstants) {
        this.ErrorConstants = ERROR_TAG + errorConstants;
    }
    public String getData() {
        return ErrorConstants;
    }

}
