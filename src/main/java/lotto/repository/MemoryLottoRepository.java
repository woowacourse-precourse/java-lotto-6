package lotto.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public class MemoryLottoRepository implements LottoRepository {
    private static Long id = 0L;
    private static Map<Long, Lotto> store = new HashMap<>();

    @Override
    public void save(Lotto lotto) {
        store.put(id, lotto);
        ++id;
    }

    @Override
    public List<Lotto> findAll() {
        return store.values()
                .stream()
                .toList();
    }
}
