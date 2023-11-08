package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos makeLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
