package lotto.domain;

import lotto.utils.RandomGeneratorUtil;

public class LottoMachine {
    public Lotto generateLotto() {
        return new Lotto(RandomGeneratorUtil.generateRandomNumbers());
    }
}
