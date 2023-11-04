package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    private final List<Lotto> lottoRepository = new ArrayList<>();

    public void saveLotto(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public Lotto findLottoByIndex(int index) {
        return lottoRepository.get(index);
    }

    public int checkRepositorySize() {
        return lottoRepository.size();
    }
}
