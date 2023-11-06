package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.model.dto.LottoPaper;

public class Buyer {
    private final Money purchasingMoney;
    private final Lottos lottos;

    public Buyer(final Money purchasingMoney, final Lottos lottos) {
        validate(purchasingMoney, lottos);
        this.purchasingMoney = purchasingMoney;
        this.lottos = lottos;
    }

    private void validate(final Money purchasingMoney, final Lottos lottos) {
        Objects.requireNonNull(purchasingMoney);
        Objects.requireNonNull(lottos);
    }

    public List<LottoPaper> getLottoPapers() {
        return lottos.createLottoPapers();
    }
}
