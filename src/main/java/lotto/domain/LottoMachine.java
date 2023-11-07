package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.util.random.NumberGenerator;

public record LottoMachine(NumberGenerator numberGenerator) {

    public Lottos issue(int issueAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueAmount; i++) {
            lottos.add(new Lotto(numberGenerator.generateSorted()));
        }
        return new Lottos(lottos);
    }
}
