package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.util.Constants.*;

public class LottoNumberGenerator implements RandomNumberGenerator {
    @Override
    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_RANGE, LOTTO_NUMBER_END_RANGE, LOTTO_NUMBER_SIZE);
    }
}
