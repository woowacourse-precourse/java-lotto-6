package lotto.domain.lotto.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class PickRandomNumbersStrategy implements PickNumbersStrategy {

    @Override
    public List<Integer> pickNumbers(int minValue, int maxValue, int count) {
        return Randoms.pickUniqueNumbersInRange(minValue, maxValue, count);
    }

}
