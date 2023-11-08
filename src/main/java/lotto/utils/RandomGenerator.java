package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {
    public static List<Integer> getRandomNumber(int minimumNumber, int maximumNumber, int lottoNumberSize) {
        return Randoms.pickUniqueNumbersInRange(minimumNumber, maximumNumber, lottoNumberSize);
    }
}
