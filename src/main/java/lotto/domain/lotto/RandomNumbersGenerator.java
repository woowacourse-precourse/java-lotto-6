package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    private final int startInclusive;
    private final int endInclusive;
    private final int count;

    public RandomNumbersGenerator(int startInclusive, int endInclusive, int count) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
