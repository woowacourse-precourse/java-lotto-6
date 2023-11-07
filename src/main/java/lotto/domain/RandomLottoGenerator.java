package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public List<Integer> create(int size) {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, size);
    }
}
