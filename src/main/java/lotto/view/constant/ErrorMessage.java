package lotto.view.constant;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    INPUT("INPUT IS NOT VALIDATE"),
    SIZE_IS_NOT_SIX("WINNING LOTTO SIZE IS NOT SIX"),
    IS_NOT_NUMBER_LIST("LOTTO IS NOT NUMBER LIST, AVAILABLE ONLY NUMBER"),
    PAY_NOT_MULTIPLE_OF_1000("USER AMOUNT PAID IS NOT A MULTIPLE OF 1000"),
    IS_NOT_NUMBER("IS NOT A NUMBER, INPUT IS ONLY NUMBER"),
    PAY_IS_NOT_POSITIVE("USER AMOUNT PAID IS NOT POSITIVE"),
    DUPLICATE_NUMBER("LOTTO NUMBERS MUST NOT CONTAINS DUPLICATE NUMBERS"),
    LOTTO_OUT_OF_RANGE("LOTTO NUMBER IS OUT OF RANGE, ONLY 1 to 45");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
