package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(final Lotto lotto) {
        this.lottos.add(lotto);
    }

    public boolean contain(final Lotto lotto) {
        return lottos.stream()
                .anyMatch(l -> l.countMatchingNumbers(lotto) == lotto.size());
    }

    public List<Rank> matched(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .toList();
    }
}
