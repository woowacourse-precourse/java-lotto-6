package lotto.util;

import static lotto.util.message.Digit.LOTTO_RANGE_END;
import static lotto.util.message.Digit.LOTTO_RANGE_START;
import static lotto.util.message.Digit.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumber {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START.getNumber(), LOTTO_RANGE_END.getNumber(),
                LOTTO_SIZE.getNumber()
        );
    }

}
