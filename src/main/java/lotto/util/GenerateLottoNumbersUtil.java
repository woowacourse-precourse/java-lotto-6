package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GenerateLottoNumbersUtil {

    private static final int GENERATE_START_RANGE_NUMBER = 1;
    private static final int GENERATE_END_RANGE_NUMBER = 45;
    private static final int GENERATE_COUNT = 6;

    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(GENERATE_START_RANGE_NUMBER, GENERATE_END_RANGE_NUMBER, GENERATE_COUNT);
    }
}
