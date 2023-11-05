package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    private PurchasedLottos(Money money) {
        lottos = createLottos(money);
    }

    public static PurchasedLottos from(Money money) {
        return new PurchasedLottos(money);
    }

    private List<Lotto> createLottos(Money money) {
        return Stream.generate(Lotto::createAuto)
                .limit(money.countPurchase())
                .toList();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int getsize() {
        return lottos.size();
    }
}
