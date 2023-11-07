package model;

public enum BonusBallCondition {

    NON_REGARD("NON_REGARD"),
    MATCH("MATCH"),
    MISMATCH("MISMATCH");

    private final String condition;

    BonusBallCondition(final String condition) {
        this.condition = condition;
    }
}
