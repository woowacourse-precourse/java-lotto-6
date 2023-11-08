package lotto.view;

public enum ErrorMessage {

    INPUT_DOES_NOT_BLANK("[ERROR] Input cannot be blank."),
    INPUT_MUST_BE_NUMERIC("[ERROR] Input must be a numeric value."),
    INPUT_MUST_BE_POSITIVE("[ERROR] Input must be a positive number."),
    INPUT_MUST_BE_MULTIPLE_OF_LOTTO_PRICE_UNIT("[ERROR] Input must be in multiples of 1000."),
    SIZE_OF_LOTTO_NUMBERS_LIST_MUST_BE_6("[ERROR] Size of Lotto numbers list must be 6"),
    LOTTO_NUMBERS_CANNOT_BE_DUPLICATED("[ERROR] Lotto numbers cannot be duplicated."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] Lotto numbers must be between 1 and 45.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
