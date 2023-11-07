package lotto.domain.money;

public enum LottoMoneyConfig {

    LOTTO_COST(1000);

    private final int value;
    LottoMoneyConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
