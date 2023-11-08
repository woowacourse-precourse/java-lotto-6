package lotto.constant;

public enum Constant {
    NUMBER_SEPARATOR(","),
    NEW_LINE("\n");
    private final String message;

    Constant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
