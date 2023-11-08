package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(int quantity) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(Lotto.createRandomLotto());
        }
    }


    public static Lottos createRandomLottos(int quantity) {
        return new Lottos(quantity);
    }



    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
