package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int ticket) {
        return new Lottos(createLottos(ticket));
    }

    private static List<Lotto> createLottos(int ticket) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottos.add(new Lotto(NumberPickMachine.pickNumbers()));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}