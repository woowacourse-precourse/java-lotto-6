package numbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class SizedNumbersGenerator {
    private final int startInclusive;
    private final int endInclusive;
    private final int count;

    public SizedNumbersGenerator(
            final int startInclusive,
            final int endInclusive,
            final int count
    ) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
