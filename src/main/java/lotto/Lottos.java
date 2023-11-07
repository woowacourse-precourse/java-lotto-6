package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public boolean contain(Lotto lotto) {
        return lottos.stream()
                .anyMatch(l -> l.countMatchingNumbers(lotto) == lotto.size());
    }

    public List<Rank> matched(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .toList();
    }
}
