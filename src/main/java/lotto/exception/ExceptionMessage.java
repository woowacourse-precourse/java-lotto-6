package lotto.exception;

public enum ExceptionMessage {

    RANDOM_NUMBER_GENERATION_ERROR("Error while generating Random Numbers: "),
    INVALID_LENGTH_RANDOM_NUMBER("Random Number must be %d long"),
    INVALID_PURCHASE_AMOUNT("Purchase amount must be in increments of 1000"),
    INVALID_RANGE_OF_BONUS_NUMBER("Bonus number must be between 1~45"),
    INVALID_INPUT_NOT_INTEGER_ERROR("Enter only Integer"),
    INVALID_NUMBER_RANGE("Lotto Number must be between 1~45"),
    EMPTY_INPUT("Winning number is empty"),
    INVALID_WINNING_NUMBER_LENGTH("Winning number must have 6 number"),
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
