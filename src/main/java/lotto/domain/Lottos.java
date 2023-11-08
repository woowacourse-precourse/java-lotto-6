package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomLottoGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos generateLottos(int count) {
        RandomLottoGenerator generator = new RandomLottoGenerator();
        List<Lotto> lottos = new ArrayList<>();
        while (count-- > 0) {
            lottos.add(new Lotto(generator.createRandomNumbers()));
        }
        return new Lottos(lottos);
    }
}
