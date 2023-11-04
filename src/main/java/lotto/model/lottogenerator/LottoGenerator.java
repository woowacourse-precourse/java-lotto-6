package lotto.model.lottogenerator;

import java.util.List;
import lotto.model.domain.Lotto;

public abstract class LottoGenerator{
    static final int LOTTO_RANGE_START = 1;
    static final int LOTTO_RANGE_END = 45;
    static final int LOTTO_SIZE = 6;

    abstract public Lotto generate();
}
