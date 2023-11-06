package lotto.common.constants;

public enum Unit {
    KOREA_MONEY("원"),
    PERCENT("%");

    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
