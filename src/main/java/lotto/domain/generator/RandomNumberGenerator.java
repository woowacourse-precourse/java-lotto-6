package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private RandomNumberGenerator() {
    }

    private static class NumberGeneratorHolder {
        private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    }

    public static RandomNumberGenerator getInstance() {
        return NumberGeneratorHolder.randomNumberGenerator;
    }

    @Override
    public List<Integer> generateNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
