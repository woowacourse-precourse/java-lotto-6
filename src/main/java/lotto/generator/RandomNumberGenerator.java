package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    private static final int STARTING_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;

    public static List<Integer> generateUniqueRandomValues(){
        return Randoms.pickUniqueNumbersInRange(STARTING_RANGE, END_RANGE, COUNT);
    }

}
