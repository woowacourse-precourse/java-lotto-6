package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.utils.constant.LottoConstant;

public class RandomUtils {
    public static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_NUMBER_MIN, LottoConstant.LOTTO_NUMBER_MAX, LottoConstant.LOTTO_NUMBER_COUNT);
    }
}
