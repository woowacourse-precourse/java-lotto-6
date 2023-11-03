package lotto;

public enum Pattern {
    ONLY_INTEGERS("\\d+");

    private final String value;

    Pattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
