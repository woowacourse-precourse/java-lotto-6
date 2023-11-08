package lotto.domain;

import java.util.List;

public final class ManualLottoGenerator implements LottoGenerator {

    @Override
    public Lottos generate(int availablePurchase) {
        return new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }

    public Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }
}
