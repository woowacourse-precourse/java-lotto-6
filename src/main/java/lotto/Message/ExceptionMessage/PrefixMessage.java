package lotto.Message.ExceptionMessage;

enum PrefixMessage {
    ERROR_MESSAGE("[ERROR] ");

    private final String message;

    PrefixMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
