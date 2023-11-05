package lotto.domain;

import java.util.stream.IntStream;

final class LottoFactory {

    private final LottoGenerator generator;

    public LottoFactory(LottoGenerator generator) {
        this.generator = generator;
    }

    Lottos createLottos(int size) {
        Lottos lottos = new Lottos();
        IntStream.range(0, size)
                .mapToObj(i -> generator.generate())
                .forEach(lottos::addLotto);
        return lottos;
    }
}