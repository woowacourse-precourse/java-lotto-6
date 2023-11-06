package lotto.domain;

import java.util.List;
import lotto.domain.generator.LottoGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createByGenerator(int lottoCount) {
        return new Lottos(LottoGenerator.generateLottos(lottoCount));
    }

    public static Lottos createByInput(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
