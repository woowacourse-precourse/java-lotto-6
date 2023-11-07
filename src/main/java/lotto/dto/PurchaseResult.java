package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class PurchaseResult {
    private final List<Lotto> lottos;

    public PurchaseResult(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getLottosCount() {
        return this.lottos.size();
    }
}
