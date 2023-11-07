package lotto.domain.randomnumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class SystemRandomNumberPicker implements RandomNumberPicker {

    @Override
    public List<Integer> pickSixUniqueNumbersInRange(int startInclusive, int endInclusive) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, 6);
    }

}
