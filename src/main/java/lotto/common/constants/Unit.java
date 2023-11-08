package lotto.common.constants;

public enum Unit {
    KOREA_MONEY("원"),
    PERCENT("%"),
    TOTAL_NUMBER("개");

    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
