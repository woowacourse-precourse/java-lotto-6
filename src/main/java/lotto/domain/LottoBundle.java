package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private static final String DELIMITER = "\n";
    private final List<Lotto> lottos;

    private LottoBundle(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoBundle from(final List<Lotto> lottos) {
        return new LottoBundle(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(DELIMITER));
    }
}
