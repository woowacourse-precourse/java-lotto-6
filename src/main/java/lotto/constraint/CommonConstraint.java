package lotto.constraint;

public enum CommonConstraint {
    DELIMITER(",");

    private final String value;

    CommonConstraint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}