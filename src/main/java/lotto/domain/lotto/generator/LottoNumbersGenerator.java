package lotto.domain.lotto.generator;

import java.util.List;

public abstract class LottoNumbersGenerator {
    protected static final int START_INCLUSIVE = 1;
    protected static final int END_INCLUSIVE = 45;
    protected static final int COUNT = 6;

    public abstract List<Integer> generateLottoNumbers();
}
