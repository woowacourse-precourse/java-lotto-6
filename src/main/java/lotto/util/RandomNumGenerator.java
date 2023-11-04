package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class RandomNumGenerator {

    private RandomNumGenerator(){

    }

    public static List<Integer> makeUniqueRandomList(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
