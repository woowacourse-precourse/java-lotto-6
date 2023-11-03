package lotto.Message.ExceptionMessage;

public enum PrefixMessage {

    ERROR_MESSAGE("[ERROR] "),
    ;

    private String message;

    PrefixMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
