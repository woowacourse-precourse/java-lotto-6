package lotto.exception;

public enum LottoException {

    NOT_SIX_NUMBERS("로또 번호는 6개여야 합니다."),
    NOT_DUPLICATE("로또 번호는 중복되지 않아야 합니다."),
    NOT_NEGATIVE_NUM("구입 금액은 음수가 아니어야 합니다."),
    INVALID_MONEY_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    INVALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String exceptionMessage;

    LottoException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        printExceptionMessage();
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    private void printExceptionMessage() {
        String ERROR = "[ERROR] ";
        System.out.println(ERROR + this.exceptionMessage);
    }
}
