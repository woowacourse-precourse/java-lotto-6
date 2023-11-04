package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbers implements NumberPicker {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> pick() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, COUNT);
    }
}
