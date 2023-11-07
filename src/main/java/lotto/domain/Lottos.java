package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> convertToRank(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningNumbers, bonusNumber))
                .toList();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Lottos lottos1 = (Lottos) object;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
