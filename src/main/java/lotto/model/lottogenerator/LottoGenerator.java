package lotto.model.lottogenerator;

import java.util.List;
import lotto.model.Lotto;

public abstract class LottoGenerator implements ListGenerator<Integer> {
    static final int LOTTO_RANGE_START = 1;
    static final int LOTTO_RANGE_END = 45;
    static final int LOTTO_SIZE = 6;

    public Lotto generate() {
        List<Integer> lottoNumbers = generateList();
        lottoNumbers.sort(Integer::compareTo);
        return new Lotto(lottoNumbers);
    }
}
