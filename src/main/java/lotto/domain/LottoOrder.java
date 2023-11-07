package lotto.domain;

public class LottoOrder {
    private final Money money;
    private final LottoBundle lottos;

    private LottoOrder(final Money money, final LottoBundle lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static LottoOrder of(final Money money, final LottoBundle lottos) {
        return new LottoOrder(money, lottos);
    }

    public int getOrderQuantity(final int price) {
        return money.calculateLottoQuantity(price);
    }

    public LottoBundle getLottos() {
        return lottos;
    }
}