package lotto.view;

public enum ErrorMessage {

    INPUT_DOES_NOT_BLANK("[ERROR] Input cannot be blank."),
    INPUT_MUST_BE_NUMERIC("[ERROR] Input must be a numeric value."),
    INPUT_MUST_BE_POSITIVE("[ERROR] Input must be a positive number."),
    INPUT_MUST_BE_MULTIPLE_OF_LOTTO_PRICE_UNIT("[ERROR] Input must be in multiples of 1000.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
