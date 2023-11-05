package lotto.model.domain;

import java.util.ArrayList;

public class Lottos {

    private final ArrayList<Lotto> lottos;

    public Lottos(ArrayList<Lotto> lottos) {
        this.lottos = lottos;
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getLottoOfLottos(int idx) {
        return lottos.get(idx);
    }
}
