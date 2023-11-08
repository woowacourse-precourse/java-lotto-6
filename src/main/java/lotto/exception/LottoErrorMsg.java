package lotto.exception;

public enum LottoErrorMsg {
    DUPLICATED("A Lottery contains a duplicated number."),
    OUT_OF_RANGE("Lottery number should be in (1,45)."),

    BONUS_DUPLICATED("Bonus Number contains a duplicated number."),

    UNABLE_TO_PARSE_INT("Unable to parse to integer type."),

    UNABLE_TO_DIVIDE("Unable to divide."),

    NEGATIVE_INT("Negative Integer or 0 are not allowed.");
    private final String prefixErrorMessage = "[ERROR] ";
    private final String message;

    LottoErrorMsg(String message) {
        this.message = message;
    }

    public String getMessage() {

        return prefixErrorMessage+message;
    }
}
