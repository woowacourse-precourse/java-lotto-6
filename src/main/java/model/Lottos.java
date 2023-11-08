package model;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public void initLottos(List<Lotto> lottos) {

        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {

        return lottos;
    }
}
