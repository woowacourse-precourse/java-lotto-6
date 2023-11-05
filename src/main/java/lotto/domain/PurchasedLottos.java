package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    private PurchasedLottos(Money money) {
        lottos = createLottos(money);
    }

    private List<Lotto> createLottos(Money money) {
        return IntStream.range(0, money.countPurchase())
                .mapToObj(i -> Lotto.createAuto())
                .toList();
    }

    public PurchasedLottos from(Money money) {
        return new PurchasedLottos(money);
    }
}
