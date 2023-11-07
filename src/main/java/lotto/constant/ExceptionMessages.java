package lotto.constant;

public enum ExceptionMessages {
    EXCEPTION_MESSAGE("");

    private String value;

    private ExceptionMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
