package lotto.domain.lotto.generator;

import java.util.List;
import lotto.domain.lotto.Lotto;

public interface LottoGenerator {
    int LOTTO_NUMBER_START = 1;
    int LOTTO_NUMBER_END = 45;
    int LOTTO_SIZE = 6;

    List<Integer> pickLottoNumbers();

    default Lotto generate() {
        List<Integer> lottoNumbers = pickLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}
