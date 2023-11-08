package lotto.domain;

public class LottoMoney {

    public static final int MONEY_UNIT = 1000;

    private final int value;

    public LottoMoney(int money) {
        this.value = money;
    }

    public int getLottoAmount() {
        return value / MONEY_UNIT;
    }
}
