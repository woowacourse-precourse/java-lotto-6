package lotto.domain.lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator extends LottoGenerator {
    @Override
    protected List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_SIZE);
    }
}
