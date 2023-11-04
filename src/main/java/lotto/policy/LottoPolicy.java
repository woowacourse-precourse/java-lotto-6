package lotto.policy;

public enum LottoPolicy {
    LOTTO_AMOUNT(1000);

    private final int value;

    private LottoPolicy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
