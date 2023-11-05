package lotto.domain;

public enum ErrorMessage {

    OVER_SIX_NUMBERS_LENGTH("ARRAY_LENGTH_GREATER_THAN_6"),
    INCLUDE_DUPLICATE_NUMBER("LIST_HAS_DUPLICATED_NUMBER"),
    OUT_OF_RANGE_NUMBER("NUMBER_OUT_OF_RANGE");

    private static final String ERROR = "[ERROR] ";
    private final String message;
    ErrorMessage(String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }
}
