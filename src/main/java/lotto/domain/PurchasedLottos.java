package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
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
        return IntStream.range(0, money.countPurchase())
                .mapToObj(i -> Lotto.createAuto())
                .toList();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int getsize() {
        return lottos.size();
    }
}
