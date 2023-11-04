package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class UniqueRandomNumbersGenerator implements NumberGenerator {
    private static final Integer LOTTO_LENGTH = 6;
    private static final Integer RANGE_START_NUMBER = 1;
    private static final Integer RANGE_END_NUMBER = 45;
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANGE_START_NUMBER, RANGE_END_NUMBER, LOTTO_LENGTH);
    }

}
