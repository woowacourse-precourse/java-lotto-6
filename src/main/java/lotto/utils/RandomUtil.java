package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static List<Integer> createLottoNumber(int minValue, int maxValue, int uniqueNumbers) {
        return Randoms.pickUniqueNumbersInRange(minValue, maxValue, uniqueNumbers);
    }
}
