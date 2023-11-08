package lotto.model;

public class LottoCount {
    private final int lottoCount;

    public LottoCount(Money money) {
        lottoCount = money.getMoney() / Money.DEFAULT_UNIT;
    }
}
