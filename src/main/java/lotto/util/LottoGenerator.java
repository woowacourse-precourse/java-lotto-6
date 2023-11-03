package lotto.util;

import lotto.model.Lotto;

public interface LottoGenerator {
    static final int LOTTO_SIZE = 6;

    Lotto generate();
}
