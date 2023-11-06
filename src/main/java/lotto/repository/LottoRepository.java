package lotto.repository;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {

    private static final LottoRepository instance = new LottoRepository();
    private static final Map<Long, Lotto> store = new HashMap<>();

    private static long id = 0L;

    private LottoRepository() {
    }

    public static LottoRepository getInstance() {
        return instance;
    }

    public void saveAll(List<Lotto> lottos) {
        lottos.forEach(lotto -> store.put(++id, lotto));
    }

    public int count() {
        return store.size();
    }
}
