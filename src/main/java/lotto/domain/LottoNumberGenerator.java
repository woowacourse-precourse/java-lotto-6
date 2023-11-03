package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;

import java.util.List;

public class LottoNumberGenerator {
    private static final int SIZE = LottoConfig.SIZE.getValue();
    private static final int RANGE_START = LottoConfig.RANGE_START.getValue();
    private static final int RANGE_END = LottoConfig.RANGE_END.getValue();

    private LottoNumberGenerator() {
        // 인스턴스화 방지
    }

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, SIZE);
        return sort(numbers);
    }

    public static List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }
}
