package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    private PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos of(List<Lotto> lottos) {
        return new PurchasedLottos(lottos);
    }

    public static PurchasedLottos from(Money money) {
        return new PurchasedLottos(createLottos(money));
    }

    private static List<Lotto> createLottos(Money money) {
        return Stream.generate(Lotto::createAuto)
                .limit(money.countPurchase())
                .toList();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int getSize() {
        return lottos.size();
    }
}
