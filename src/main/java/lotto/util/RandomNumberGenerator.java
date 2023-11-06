package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> randomUniqueNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
