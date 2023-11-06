package lotto.model;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void showLottos() {
        for (Lotto lotto : lottos) {
            lotto.showLotto();
        }
    }

}
