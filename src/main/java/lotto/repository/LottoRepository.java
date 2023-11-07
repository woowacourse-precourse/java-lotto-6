package lotto.repository;

import lotto.domain.Lottos;

public class LottoRepository {
    private Lottos lottos;
    public void saveAll(Lottos lottos) {
        this.lottos = lottos;
    }
}
