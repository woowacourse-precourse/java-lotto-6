package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.number.NumberGenerator;

public class LottoFactory {
    private final NumberGenerator generator;

    public LottoFactory(final NumberGenerator generator) {
        this.generator = generator;
    }

    public LottoBundle createBundle(final int count) {
        final List<Lotto> lottos = IntStream
                .range(0, count)
                .mapToObj(i -> new Lotto(generator.generate()))
                .toList();
        return LottoBundle.from(lottos);
    }
}

