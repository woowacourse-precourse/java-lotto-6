package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.Value;

import java.util.Collections;
import java.util.List;

public class RandomUtils {

    public List<Integer> sixUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(Value.LOTTO_START_NUMBER, Value.LOTTO_END_NUMBER, Value.LOTTO_NUMBER_SIZE);
    }

    public int RandomNumber() {
        return Randoms.pickNumberInRange(1, 45);
    }
}
