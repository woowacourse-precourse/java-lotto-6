package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottosByLottoCount(long lottoCount) {
        List<Lotto> randomLottos = new ArrayList<>();
        while (lottoCount-- != 0) {
            randomLottos.add(Lotto.generateRandomLottoNumbers());
        }
        return new Lottos(randomLottos);
    }
}
