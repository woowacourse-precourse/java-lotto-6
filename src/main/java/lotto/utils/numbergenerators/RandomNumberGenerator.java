package lotto.utils.numbergenerators;

import camp.nextstep.edu.missionutils.Randoms;

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
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, RANGE);
    }
}
