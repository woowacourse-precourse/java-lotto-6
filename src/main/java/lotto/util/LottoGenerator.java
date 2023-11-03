package lotto.util;

import lotto.model.Lotto;

public interface LottoGenerator {
    static final int LOTTO_RANGE_START = 1;
    static final int LOTTO_RANGE_END = 45;
    static final int LOTTO_SIZE = 6;

    Lotto generate();
}
