package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 45;

    @Override
    public List<Integer> create(int size) {
        return Randoms.pickUniqueNumbersInRange(RANGE_MIN, RANGE_MAX, size);
    }
}
