package lotto.constant;

public enum ErrorMessage {
    IS_NULL_MESSAGE("빈 문자열 입니다"),
    IS_NOT_NUMBER_MESSAGE("숫자가 아닙니다"),
    IS_NOT_EXPRESS_NUMBER_RANGE_MESSAGE("정수의 형태로 표현할 수 없습니다"),
    IS_NOT_NUMBER_Range_MESSAGE("0이하 입니다"),
    IS_NOT_MONEY_UNIT_MESSAGE(LottoInformation.MONEY_UNIT.getNumber() + "원 단위가 아닙니다"),
    IS_NOT_LOTTO_SIZE_MESSAGE("번호가 6개가 아닙니다"),
    IS_NOT_LOTTO_RANGE_MESSAGE("1~45의 번호가 아닙니다"),
    IS_DUPLICATION_LOTTO_NUMBER_MESSAGE("중복된 숫자가 있습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message ="[Error] " + message;
    }

    public String getMessage() {
        return message;
    }
}
