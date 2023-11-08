package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Prize> match(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}