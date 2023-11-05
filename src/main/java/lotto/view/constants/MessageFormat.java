package lotto.view.constants;

public enum MessageFormat {
    LINE_SEPARATOR(System.lineSeparator());

    private final String value;

    MessageFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
