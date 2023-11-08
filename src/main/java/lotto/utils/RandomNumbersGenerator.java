package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator {
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final int TOTAL_NUMBER = 6;

    public List<Integer> randomNumbersGenerate() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, TOTAL_NUMBER);
    }
}