package lotto.domain.generator;

import lotto.domain.Lotto;

public class LottoGenerator {
    private Lotto generateLotto() {
        RandomListGenerator generator = new RandomListGenerator();
        return new Lotto(generator.generateNumbers());
    }
}