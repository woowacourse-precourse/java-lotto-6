package util;

public enum LottoUtil {
    LOTTO_START(1),
    LOTTO_END(45),
    LOTTO_SIZE(6);
    private final int value;

    LottoUtil(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
