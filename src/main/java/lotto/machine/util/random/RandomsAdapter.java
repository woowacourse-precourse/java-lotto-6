package lotto.machine.util.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomsAdapter implements RandomsProvider {
    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}

