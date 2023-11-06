package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class MemoryRandomLottoRepository implements LottoRepository {
    private static List<Lotto> store = new ArrayList<>();
    @Override
    public void save(Lotto lotto) {
        store.add(lotto);
    }

    @Override
    public List<Lotto> getLottoList() {
        return store;
    }
}
