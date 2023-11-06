package lotto.repository;

import java.util.List;
import lotto.model.Lotto;

public interface LottoRepository {
    void save(Lotto lotto);
    List<Lotto> findAll();
}
