package lotto.domain;

import java.util.List;

public record Lottos(List<Lotto> lottoGroup) {
    public Lottos(final List<Lotto> lottoGroup) {
        this.lottoGroup = List.copyOf(lottoGroup);
    }

    public int getSize() {
        return lottoGroup.size();
    }
}
