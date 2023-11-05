package lotto.domain.parser.constants;

public enum InputConstraint {
    DELIMITER(",");

    private final String value;

    InputConstraint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
