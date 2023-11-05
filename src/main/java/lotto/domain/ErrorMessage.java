package lotto.domain;

public enum ErrorMessage {

    OVER_SIX_NUMBERS_LENGTH("ARRAY_LENGTH_GREATER_THAN_6"),
    INCLUDE_DUPLICATE_NUMBER("LIST_HAS_DUPLICATED_NUMBER"),
    OUT_OF_RANGE_NUMBER("NUMBER_OUT_OF_RANGE"),
    NULL_OR_BLANK("NUMBER_IS_NULL_OR_BLANK"),
    NON_NUMERIC("CONTAIN_NON_NUMERIC"),
    ALREADY_DRAWN("LOTTO_NUMBER_ALREADY_DRAWN"),
    NOT_FALLING_APART("NUMBER_IS_NOT_FALLING_APART");

    private static final String ERROR = "[ERROR] ";
    private final String message;
    ErrorMessage(String errorMessage) {
        this.message = ERROR + errorMessage;
    }

    public String getMessage() {
        return message;
    }
}
