package lotto.domain.lotto;

import java.util.List;

public record Lottos(List<Lotto> lottos) {
    public Lottos(final List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public int getSize() {
        return lottos.size();
    }
}
