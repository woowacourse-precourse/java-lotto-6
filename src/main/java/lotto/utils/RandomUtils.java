package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUtils {

    public List<Integer> sixUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int RandomNumber() {
        return Randoms.pickNumberInRange(1, 45);
    }
}
