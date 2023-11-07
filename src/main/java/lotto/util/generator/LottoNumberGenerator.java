package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 45;
    private static final int NUMBER_COUNT = 6;

    public List<Integer> generate() {
        List<Integer> randomNumber = new ArrayList<>(
            Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_START, NUMBER_RANGE_END, NUMBER_COUNT));
        randomNumber.sort(Comparator.naturalOrder());

        return randomNumber;
    }
}
