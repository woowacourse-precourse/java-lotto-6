package lotto.model;

import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Lottos.class.getSimpleName() + "[", "]")
                .add("lottos=" + lottos)
                .toString();
    }
}
