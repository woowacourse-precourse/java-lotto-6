package lotto.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    private final List<Lotto> lottoRepository = new ArrayList<>();

    public void saveLotto(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public int checkRepositorySize() {
        return lottoRepository.size();
    }

    public List<Lotto> getAllLottos() {
        return Collections.unmodifiableList(lottoRepository);
    }
}
