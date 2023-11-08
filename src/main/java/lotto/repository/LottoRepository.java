package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();
    private final int numberOfLotto;

    public LottoRepository(int numberOfLotto) {
        //유효성 검사
        this.numberOfLotto = numberOfLotto;
    }

    public void createLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }
}
