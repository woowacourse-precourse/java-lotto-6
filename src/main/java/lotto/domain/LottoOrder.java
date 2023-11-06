package lotto.domain;

public class LottoOrder {
    private final Money money;
    private final LottoBundle lottos;

    public LottoOrder(final Money money, final LottoBundle lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public int getBuyQuantity(final int price) {
        return money.calculateLottoQuantity(price);
    }

    public LottoBundle getLottos() {
        return lottos;
    }
}