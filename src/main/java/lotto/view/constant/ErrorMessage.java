package lotto.view.constant;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    PAY_NOT_MULTIPLE_OF_1000("USER AMOUNT PAID IS NOT A MULTIPLE OF 1000"),
    PAY_NOT_NUMBER("USER AMOUNT PAID IS NOT A NUMBER"),
    PAY_IS_ZERO("USER AMOUNT PAID IS ZERO");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
