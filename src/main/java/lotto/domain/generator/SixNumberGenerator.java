package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class SixNumberGenerator {

    private SixNumberGenerator() {
    }

    public static List<Integer> getRandomSixNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
