package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class UniqueRandomNumbersGenerator implements NumberGenerator{
    @Override
    public List<Integer> generate(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }


}
