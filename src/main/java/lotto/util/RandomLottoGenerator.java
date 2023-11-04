package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class RandomLottoGenerator implements LottoGenerator{

    @Override
    public Lotto generate() {
        List<Integer> lottoNumbers =
                Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_SIZE);
        lottoNumbers.sort(Integer::compareTo);
        return new Lotto(lottoNumbers);
    }
}
