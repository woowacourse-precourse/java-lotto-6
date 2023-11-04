package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGenerator;

public final class LottoDispenser {
    private final LottoGenerator lottoGenerator;

    public LottoDispenser(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    private Lotto createLotto() {
        return lottoGenerator.generate();
    }

    public Lottos dispense(int amount) {
        List<Lotto> elements = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            elements.add(createLotto());
        }
        return new Lottos(elements);
    }
}
