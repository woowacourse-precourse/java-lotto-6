package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<String> getLottosPrintFormat() {
        return lottos.stream().map(Lotto::getNumbersPrintFormat).toList();
    }
}
