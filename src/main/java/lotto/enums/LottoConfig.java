package lotto.enums;

public enum LottoConfig {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6);
    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
