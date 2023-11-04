package lotto.exception;

public enum ExceptionMessage {

    RANDOM_NUMBER_GENERATION_ERROR("Error while generating Random Numbers: "),
    INVALID_LENGTH_RANDOM_NUMBER("Random Number must be %d long"),
    INVALID_DUPLICATE_NUMBER("Duplicate in Lotto Numbers");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
