package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNum {
    public static List<Integer> createRandomNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
