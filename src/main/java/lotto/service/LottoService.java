package lotto.service;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoService {
    void recordLotto(Lotto lotto);
    List<Lotto> getAllLottoRecord();
}
