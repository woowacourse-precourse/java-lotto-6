package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private List<Lotto> lottoRepository = new ArrayList<>();

    public int size() {
        return lottoRepository.size();
    }

    public void add(final Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public Lotto get(final int index) {
        return lottoRepository.get(index);
    }

    public void printAllLottoInfo() {
        lottoRepository.forEach(Lotto::printLottoInfo);
    }
}
