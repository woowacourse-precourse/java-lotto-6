package lotto.util;

import static lotto.constants.LottoConstants.LOTTO_SIZE;
import static lotto.constants.LottoConstants.MAX_RANGE;
import static lotto.constants.LottoConstants.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto lottoGenerator() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);
        return new Lotto(lottoNumbers.stream()
                .sorted()
                .toList());
    }
}
