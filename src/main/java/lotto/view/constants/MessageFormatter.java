package lotto.view.constants;

public enum MessageFormatter {
    LINE_SEPARATOR(System.lineSeparator()),
    ERROR_MESSAGE_PREFIX("[ERROR] ");

    private final String value;

    MessageFormatter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
