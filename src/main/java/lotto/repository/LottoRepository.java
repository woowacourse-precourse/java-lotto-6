package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    private final List<Lotto> lottoRepository = new ArrayList<>();

    public void saveLotto(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public List<Integer> findLottoNumbersByIndex(int index) {
        Lotto foundLotto = lottoRepository.get(index);
        return new ArrayList<>(foundLotto.getLotto());
    }

    public int checkRepositorySize() {
        return lottoRepository.size();
    }
}
