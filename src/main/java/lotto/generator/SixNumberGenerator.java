package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.RegularConstant;
import lotto.constant.SixNumberGeneratorConstant;

import java.util.List;

public final class SixNumberGenerator {

    private SixNumberGenerator() {
    }

    public static List<Integer> run() {
        return Randoms.pickUniqueNumbersInRange(
                SixNumberGeneratorConstant.START_OF_NUMBER_RANGE,
                SixNumberGeneratorConstant.END_OF_NUMBER_RANGE,
                SixNumberGeneratorConstant.COUNT_OF_NUMBERS_CAN_HAVE
        );
    }
}
