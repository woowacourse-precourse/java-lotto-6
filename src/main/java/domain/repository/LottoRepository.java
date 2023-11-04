package domain.repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();
    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getAllLotto() {
        return lottos;
    }
}
