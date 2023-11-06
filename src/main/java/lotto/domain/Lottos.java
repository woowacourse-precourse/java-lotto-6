package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final int quantity) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto createLotto = Lotto.createLotto();
            generatedLottos.add(createLotto);
        }
        return new Lottos(generatedLottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
