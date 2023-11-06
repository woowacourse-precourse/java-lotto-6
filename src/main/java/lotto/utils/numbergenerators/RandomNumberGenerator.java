package lotto.utils.numbergenerators;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;


public class RandomNumberGenerator implements NumberGenerator {
    private static RandomNumberGenerator randomNumberGenerator;

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        if (randomNumberGenerator == null) {
            randomNumberGenerator = new RandomNumberGenerator();
        }
        return randomNumberGenerator;
    }

    @Override
    public List<Integer> generateNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, RANGE);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
