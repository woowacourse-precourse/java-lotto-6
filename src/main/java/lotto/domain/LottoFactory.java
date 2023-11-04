package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.number.NumberGenerator;

public class LottoFactory {

    private LottoFactory() {
    }

    public static LottoBundle createLottos(final int count, final NumberGenerator generator) {
        final List<Lotto> lottos = IntStream
                .range(0, count)
                .mapToObj(i -> new Lotto(generator.generate()))
                .toList();
        return LottoBundle.create(lottos);
    }
}
