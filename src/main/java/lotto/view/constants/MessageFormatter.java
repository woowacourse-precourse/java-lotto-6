package lotto.view.constants;

public enum MessageFormatter {
    LINE_SEPARATOR(System.lineSeparator()),
    ERROR_MESSAGE_PREFIX("[ERROR] ");

    public final String value;

    MessageFormatter(String value) {
        this.value = value;
    }
}
