package lotto.constants;

public enum Boolean {
    TRUE(true),
    FALSE(false);

    private final boolean trueAndFalse;

    Boolean(boolean trueAndFalse) {
        this.trueAndFalse = trueAndFalse;
    }

    public boolean get() {
        return trueAndFalse;
    }
}
