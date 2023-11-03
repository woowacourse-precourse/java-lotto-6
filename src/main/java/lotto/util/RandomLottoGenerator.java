package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;

public class RandomLottoGenerator implements LottoGenerator{

    @Override
    public Lotto generate() {
        List<Integer> lottoNumbers =
                Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }
}
