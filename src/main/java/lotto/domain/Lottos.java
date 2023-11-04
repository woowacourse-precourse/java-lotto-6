package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.strategy.IssuableStrategy;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final int totalCount, final IssuableStrategy issuableStrategy) {
        this.lottos = createLottos(totalCount, issuableStrategy);
    }

    private List<Lotto> createLottos(final int totalCount, final IssuableStrategy issuableStrategy) {
        return IntStream.rangeClosed(1, totalCount)
                .mapToObj(count -> issuableStrategy.issue())
                .toList();
    }

    public int count() {
        return lottos.size();
    }

}
