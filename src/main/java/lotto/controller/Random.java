package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Random {
    public List<Integer> makeRandom() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randoms);
        return randoms;
    }
}
