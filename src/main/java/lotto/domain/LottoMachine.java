package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.util.random.NumberGenerator;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos issue(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getIssueAmount(); i++) {
            lottos.add(new Lotto(numberGenerator.generateSorted()));
        }
        return new Lottos(lottos);
    }

}
