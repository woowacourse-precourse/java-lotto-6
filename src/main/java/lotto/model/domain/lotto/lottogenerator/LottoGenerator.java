package lotto.model.domain.lotto.lottogenerator;

import lotto.model.domain.lotto.Lotto;

public abstract class LottoGenerator<L extends Lotto> {
    abstract public L generate();
}
