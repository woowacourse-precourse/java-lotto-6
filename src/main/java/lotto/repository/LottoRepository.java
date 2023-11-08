package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {

    private final List<Lotto> lottos = new ArrayList<>();

    private static final LottoRepository instance = new LottoRepository();

    private LottoRepository() {

    }

    public static LottoRepository getInstance() {
        return instance;
    }

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return lottos;
    }
}
