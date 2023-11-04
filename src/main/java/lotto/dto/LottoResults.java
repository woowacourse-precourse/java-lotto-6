package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public class LottoResults {
    private final List<Lotto> lottos;

    public LottoResults(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
