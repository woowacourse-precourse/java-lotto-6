package lotto.constants.messages;

public enum Error {
    ERORR("[ERROR]");


    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}