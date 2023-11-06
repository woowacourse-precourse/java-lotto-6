package lotto.domain.config;

public enum ValidatorConfig {
    ERROR_MESSAGE("[ERROR] "),
    ;

    private final String message;

    ValidatorConfig(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
