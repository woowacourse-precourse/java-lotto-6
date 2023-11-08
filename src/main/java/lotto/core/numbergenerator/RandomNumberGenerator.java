package lotto.core.numbergenerator;

import static lotto.core.enums.LottoNumberEnum.END_VALUE;
import static lotto.core.enums.LottoNumberEnum.SIZE;
import static lotto.core.enums.LottoNumberEnum.START_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> createRandomUniqueNumber() {
        return Randoms.pickUniqueNumbersInRange(START_VALUE.getValue(), END_VALUE.getValue(), SIZE.getValue());
    }
}
