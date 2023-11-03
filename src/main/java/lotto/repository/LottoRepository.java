package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    private Long id = 0L;
    private final Map<Long, Lotto> lotteries = new HashMap<>();

    public Long save(Lotto lotto) {
        lotteries.put(id, lotto);
        id += 1;
        return id;
    }

    public Lotto findById(Long id) {
        return lotteries.get(id);
    }

    public List<Lotto> findAll() {
        return new ArrayList<>(lotteries.values());
    }
}
