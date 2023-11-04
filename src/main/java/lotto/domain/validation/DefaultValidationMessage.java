package lotto.domain.validation;

public enum DefaultValidationMessage {
    ERROR("[ERROR]");

    private final String message;

    DefaultValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
