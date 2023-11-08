package lotto.exception;

public enum LottoException {
    ERROR("ERROR"),
    NUMBER_OF_NUMBERS_EXCEPTION(ERROR + "번호는 총 6개 입니다"),
    WINNING_NUMBER_RANGE_EXCEPTION(ERROR + "1~45의 수만 입력할 수 있습니다"),
    WINNING_NUMBER_DUPLICATES_EXCEPTION(ERROR + "중복인 수가 있습니다"),
    EMPTY_INPUT_EXCEPTION(ERROR + "알 수 없는 입력"),
    AMOUNT_RANGE_EXCEPTION(ERROR + "구입 금액은 천원 이상 입니다"),
    AMOUNT_UNIT_EXCEPTION(ERROR + "1000원 단위로 구입 가능 합니다"),
    NOT_NUMBER_EXCEPTION(ERROR + "숫자가 아닙 니다"),
    ALREADY_IN_WINNING_NUMBER_EXCEPTION(ERROR + "당첨 번호에 이미 존재 하는 번호 입니다");

    private final String exceptionMessage;

    LottoException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public void throwing() {
        System.out.println(exceptionMessage);
        throw new IllegalArgumentException(exceptionMessage);
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
