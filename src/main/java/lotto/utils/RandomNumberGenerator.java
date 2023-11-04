package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, RANGE);
    }
}
