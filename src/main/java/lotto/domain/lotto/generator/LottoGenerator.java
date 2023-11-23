package lotto.domain.lotto.generator;

import java.util.List;
import lotto.domain.lotto.entity.Lotto;

public abstract class LottoGenerator {
    protected static final int LOTTO_NUMBER_START = 1;
    protected static final int LOTTO_NUMBER_END = 45;
    protected static final int LOTTO_SIZE = 6;

    protected abstract List<Integer> pickLottoNumbers();

    public Lotto generate() {
        List<Integer> lottoNumbers = pickLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}
