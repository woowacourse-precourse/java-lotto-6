package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

public class Lottos {

    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createWith(final long money, final NumbersGenerator numbersGenerator) {
        long lottoTicketCount = money / LOTTO_PRICE;
        return new Lottos(createLottos(lottoTicketCount, numbersGenerator));
    }

    private static List<Lotto> createLottos(final long lottoTicketCount, final NumbersGenerator numbersGenerator) {
        return LongStream.range(ZERO, lottoTicketCount)
                .mapToObj(lotto -> Lotto.createWith(numbersGenerator))
                .toList();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
