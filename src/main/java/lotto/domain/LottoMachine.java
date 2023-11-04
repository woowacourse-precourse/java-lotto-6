package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.NumberGenerator;
import lotto.domain.lotto.RandomNumberGenerator;

public class LottoMachine {
    public Lotto issueLotto() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return new Lotto(randomNumberGenerator.generateNumbers());
    }

}
