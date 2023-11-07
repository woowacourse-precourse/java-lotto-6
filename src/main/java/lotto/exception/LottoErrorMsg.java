package lotto.exception;

public enum LottoErrorMsg {
    DUPLICATED("A Lottery contains a duplication number."),
    OUT_OF_RANGE("Lottery number should be in (1,45)");

    private final String message;

    LottoErrorMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
