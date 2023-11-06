package lotto.repository;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoRepository {
    void save(Lotto lotto);
    List<Lotto> getLottoList();
}
