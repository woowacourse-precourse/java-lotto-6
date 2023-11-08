package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final  List<Lotto> lottos) {
        this.lottos = lottos;
    }
    private List<Lotto> getLottos(){
        return this.lottos;
    }
    public List<Lotto> lottos(){
        return getLottos();
    }
}
