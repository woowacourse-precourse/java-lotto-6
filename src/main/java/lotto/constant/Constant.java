package lotto.constant;

public enum Constant {
    NUMBER_SEPARATOR(",");
    private final String message;

    Constant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
