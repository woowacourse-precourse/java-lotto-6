package lotto.domain.lotto;

import java.util.List;
import lotto.domain.validator.LottoValidator;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        LottoValidator.verifyLottosNotNullOrNotEmpty(lottos);
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
