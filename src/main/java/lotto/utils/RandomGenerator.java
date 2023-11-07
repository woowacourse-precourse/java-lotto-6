package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.Constant;

public class RandomGenerator {
    public static List<Integer> getRandomNumberList() {
        return Randoms.pickUniqueNumbersInRange(
                Constant.START_RANGE_OF_NUMBER.getContentToInteger(),
                Constant.END_RANGE_OF_NUMBER.getContentToInteger(),
                Constant.COUNT_OF_LOTTO_NUMBERS.getContentToInteger()
        );
    }
}
