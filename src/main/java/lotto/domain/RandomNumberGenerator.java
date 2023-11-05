package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class RandomNumberGenerator{

    public static List<Integer> createUniqueRandomNumbers(){
        return pickUniqueNumbersInRange(1,45,6);
    }

}
