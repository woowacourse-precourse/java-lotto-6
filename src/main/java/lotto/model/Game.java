package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Generator.createNumbers()));
        }

        return new Lottos(lottos);
    }


}
