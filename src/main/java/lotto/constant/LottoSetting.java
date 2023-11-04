package lotto.constant;

public enum LottoSetting {
    DIVISOR(1000);

    private final int value;

    LottoSetting(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
