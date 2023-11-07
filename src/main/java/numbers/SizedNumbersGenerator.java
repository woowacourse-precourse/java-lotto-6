package numbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * 정해진 크기의 unique한 랜덤 숫자를 생성하는 배열 생성기
 */
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
