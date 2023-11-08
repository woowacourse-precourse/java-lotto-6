package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void printLottos() {
        lottos.forEach(Lotto::printLotto);
    }

    public int numberOfLotto() {
        return lottos.size();
    }
}
