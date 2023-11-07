package lotto.exception;

public enum LottoErrorMsg {
    DUPLICATED("A Lottery contains a duplicated number."),
    OUT_OF_RANGE("Lottery number should be in (1,45)"),

    BONUS_DUPLICATED("Bonus Number contains a duplicated number.");
    private final String message;

    LottoErrorMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
