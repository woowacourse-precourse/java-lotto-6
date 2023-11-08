package lotto.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;
import lotto.util.generator.NumberGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos assemble(NumberGenerator numberGenerator, int lottoCount) {
        return Stream.generate(() -> Lotto.issue(numberGenerator.generate()))
                .limit(lottoCount)
                .collect(collectingAndThen(toList(), Lottos::new));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
