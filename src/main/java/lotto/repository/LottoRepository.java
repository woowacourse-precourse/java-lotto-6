package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class LottoRepository {
    private final List<Lotto> storage = new ArrayList<>();

    public void save(Lottos lottos) {
        storage.addAll(lottos.getLottos());
    }

    public List<Lotto> findAll() {
        return List.copyOf(storage);
    }
}
