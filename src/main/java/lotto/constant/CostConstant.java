package lotto.constant;

public enum CostConstant {
    UNIT(1000);
    private final int value;

    CostConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
