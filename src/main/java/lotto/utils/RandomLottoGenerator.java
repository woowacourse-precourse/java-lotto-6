package lotto.utils;

import static lotto.constants.Constants.LOTTO_SIZE;
import static lotto.constants.Constants.MAX_VALUE;
import static lotto.constants.Constants.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator {

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_SIZE);
    }
}

