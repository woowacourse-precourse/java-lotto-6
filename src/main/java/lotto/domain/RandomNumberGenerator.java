package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate(int minInclusive, int maxInclusive, int size) {
        return Randoms.pickUniqueNumbersInRange(minInclusive, maxInclusive, size);
    }
}
