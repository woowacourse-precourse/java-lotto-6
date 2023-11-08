package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.NumberGenerator;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS = 6;

    public List<Integer> createNumber() {

        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS);
    }
}
