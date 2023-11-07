package lotto.domain.repository;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Collections;

public class LottoRepository {
    private final List<Lotto> lottos ;

    private LottoRepository(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoRepository createRepository(List<Lotto> lottos) {
        return new LottoRepository(lottos);
    }

    // Query - SELECT
    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    // Query - COUNT(*)
    public long count() {
        return lottos.size();
    }

}
