package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottoCount) {
        this.lottos = LottoFactory.createLottos(lottoCount);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public List<Rank> matchAllLotto(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .toList();
    }
}
