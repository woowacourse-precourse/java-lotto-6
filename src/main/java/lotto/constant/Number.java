package lotto.constant;

public enum Number {
    MIN(1), MAX(45), CNT(6), PURCHASE_UNIT(1000)
    ;

    private final int range;

    Number(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
