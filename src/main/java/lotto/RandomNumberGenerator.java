package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int count = 6;


    public List<Integer> generateUniqueAndRandomSixNumber() {
        return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
    }

}
