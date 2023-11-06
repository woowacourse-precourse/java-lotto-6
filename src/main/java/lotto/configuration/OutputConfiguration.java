package lotto.configuration;

public enum OutputConfiguration {
    INSERT_MONEY("구입금액을 입력해 주세요.");

    private final String message;

    OutputConfiguration(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
