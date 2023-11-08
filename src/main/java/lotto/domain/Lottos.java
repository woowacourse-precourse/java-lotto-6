package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.generator.LottoGeneratorImpl;

import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos fromCount(int lottoCount, LottoGeneratorImpl lottoGenerator) {
        return new Lottos(IntStream.range(0, lottoCount)
                .mapToObj(lotto -> new Lotto(lottoGenerator.generate()))
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}