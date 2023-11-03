package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator {

    private static final int MIN_NUMBER = Number.MIN_VALUE;
    private static final int MAX_NUMBER = Number.MAX_VALUE;
    private static final int SIZE = Lotto.NUMBER_SIZE;

    private RandomLottoGenerator() {
    }

    public static Lotto generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MAX_NUMBER, MIN_NUMBER, SIZE);
        return new Lotto(randomNumbers);
    }
}
