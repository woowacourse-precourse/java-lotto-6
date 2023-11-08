package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public static List<Integer> makeNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
