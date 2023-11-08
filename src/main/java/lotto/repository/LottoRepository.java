package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();
    private int numberOfLotto;

    public void setNumberOfLotto(int numberOfLotto) {
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
