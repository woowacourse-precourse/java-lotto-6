package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSequence {
    private final List<Lotto> lottoSequence = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoSequence.add(lotto);
    }

    public int size() {
        return lottoSequence.size();
    }

    public Lotto get(int index) {
        return lottoSequence.get(index);
    }

    public void printAllLotto() {
        lottoSequence.forEach(Lotto::printLottoInfo);
    }
}
