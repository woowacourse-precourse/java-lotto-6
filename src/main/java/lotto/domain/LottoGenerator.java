package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.numbergenerator.NumberGenerator;

public class LottoGenerator {
    private final int lottoCount;
    private final NumberGenerator numberGenerator;
    private List<Lotto> lottos;

    public LottoGenerator(int lottoCount, NumberGenerator numberGenerator) {
        this.lottoCount = lottoCount;
        this.numberGenerator = numberGenerator;
    }

    public void makeLottos() {
        lottos = IntStream.range(0, lottoCount)
                        .mapToObj(i -> new Lotto(makeNumbers()))
                                .collect(Collectors.toList());
    }

    private List<Integer> makeNumbers() {
        return numberGenerator.generate();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
