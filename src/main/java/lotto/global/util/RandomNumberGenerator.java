package lotto.global.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public interface RandomNumberGenerator {
    static List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
