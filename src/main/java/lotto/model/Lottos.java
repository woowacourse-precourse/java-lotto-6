package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }
}
