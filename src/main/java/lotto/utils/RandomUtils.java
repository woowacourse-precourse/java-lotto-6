package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.constants.Value.*;

public class RandomUtils {

    public List<Integer> pickSixUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_SIZE);
    }

}
