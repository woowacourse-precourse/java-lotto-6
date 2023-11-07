package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.system.Constants;

public class RandomNumber {
    private RandomNumber() {}

    public static List<Integer> makeUniqueRandomList() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.START_NUMBER.getConstants(),
                Constants.END_NUMBER.getConstants(),
                Constants.LOTTO_SIZE.getConstants()
        );
    }
}
