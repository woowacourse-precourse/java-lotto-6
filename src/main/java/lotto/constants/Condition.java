package lotto.constants;

public enum Condition {
    TRUE(true),
    FALSE(false);

    private final boolean trueAndFalse;

    Condition(boolean trueAndFalse) {
        this.trueAndFalse = trueAndFalse;
    }

    public boolean get() {
        return trueAndFalse;
    }
}
