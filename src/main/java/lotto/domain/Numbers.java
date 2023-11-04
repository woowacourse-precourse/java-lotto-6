package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Numbers {
    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public String putCommaInNumber(long price) {
        return null;
    }

    public float rateOfReturn(int inputPrice, long outputPrice) {
        return 0;
    }
}
