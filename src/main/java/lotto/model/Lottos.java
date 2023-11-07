package lotto.model;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
    public List<Lotto> get() {
        return lottos;
    }
    public int count() {
        return lottos.size();
    }
}
