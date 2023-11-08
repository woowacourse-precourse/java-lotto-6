package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .reduce((s1, s2) -> s1 + "\n" + s2)
                .orElse("");
    }

}
