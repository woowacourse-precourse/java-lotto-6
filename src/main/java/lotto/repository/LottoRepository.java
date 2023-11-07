package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private static final List<Lotto> lottos = new ArrayList<>();

    public Lotto save(Lotto lotto) {
        lottos.add(lotto);
        return lotto;
    }

    public List<Lotto> findAll() {
        return new ArrayList<>(lottos);
    }

    public void clear() {
        lottos.clear();
    }
}
