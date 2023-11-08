package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

public class Lottos {

    private static final int ZERO = 0;

    private final List<Lotto> purchasedLottos;

    private Lottos(final List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public static Lottos createWith(final long ticketCount, final NumbersGenerator<LottoNumber> numbersGenerator) {
        return new Lottos(createLottos(ticketCount, numbersGenerator));
    }

    private static List<Lotto> createLottos(final long ticketCount,
                                            final NumbersGenerator<LottoNumber> numbersGenerator) {

        return LongStream.range(ZERO, ticketCount)
                .mapToObj(count -> new Lotto(numbersGenerator.generate()))
                .toList();
    }

    public List<Lotto> getPurchasedLottos() {
        return Collections.unmodifiableList(purchasedLottos);
    }
}
