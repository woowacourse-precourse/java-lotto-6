package lotto.exception;

public enum ExceptionMessage {
    AMOUNT_NOT_DIVISIBLE("[ERROR] The amount is not divisible by the price of a single lottery ticket."),
    NEGATIVE_AMOUNT_NOT_ALLOWED("[ERROR] The purchase amount cannot be negative."),
    AMOUNT_CANNOT_BE_ZERO("[ERROR] The purchase amount cannot be zero."),
    AMOUNT_OUT_OF_BOUNDS("[ERROR] The purchase amount is out of bounds."),
    VALUE_CANNOT_BE_EMPTY_OR_BLANK("[ERROR] It cannot be blank or an empty value."),
    NUMERIC_VALUES_ONLY("[ERROR] Only numeric values are allowed.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
