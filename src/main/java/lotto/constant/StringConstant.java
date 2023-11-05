package lotto.constant;

public enum StringConstant {

    DIVISION_STANDARD(",");

    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
