package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUtil {

    private RandomUtil() {

    }

    public static List<Integer> generateRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
