package lotto.domain.lotto;

import java.util.List;

public record Lottos(
        List<Lotto> lottos
) {
    public Lottos(List<Lotto> lottos) {
        this.lottos = makeUnmodifiable(lottos);
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private List<Lotto> makeUnmodifiable(final List<Lotto> lottos) {
        return List.copyOf(lottos);
    }
}
