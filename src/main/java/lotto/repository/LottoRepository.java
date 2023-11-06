package lotto.repository;

import java.util.Objects;
import lotto.domain.LottoStore;

public class LottoRepository {
    private LottoStore lottoStore;

    public void save(LottoStore lottoStore) {
        Objects.requireNonNull(lottoStore);
        this.lottoStore = lottoStore;
    }

    public LottoStore findLottoStore() {
        return this.lottoStore;
    }
}
