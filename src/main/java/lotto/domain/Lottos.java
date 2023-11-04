package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos){
        return new Lottos(lottos);
    }
}
