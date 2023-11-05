package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.RegularConstant;

import java.util.List;

public final class SixNumberGenerator {

    private SixNumberGenerator() {
    }

    public static List<Integer> getRandomSixNumbers() {
        return Randoms.pickUniqueNumbersInRange(RegularConstant.START_OF_NUMBER_RANGE, RegularConstant.END_OF_NUMBER_RANGE, RegularConstant.COUNT_OF_NUMBERS_CAN_HAVE);
    }
}
