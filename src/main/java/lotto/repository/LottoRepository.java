package lotto.repository;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {

    private static Long lottoId = 0L;
    private static final Map<Long, Lotto> lottoDatabase = new HashMap<>();

    public void save(Lotto lotto) {
        lottoDatabase.put(lottoId, lotto);
        lottoId++;
    }

    public void saveAll(final List<Lotto> lottos) {
        lottos.forEach(this::save);
    }

    public List<Lotto> findAll() {
        return lottoDatabase.values()
                .stream()
                .toList();
    }

    public void clear() {
        lottoDatabase.clear();
        lottoId = 0L;
    }

}
