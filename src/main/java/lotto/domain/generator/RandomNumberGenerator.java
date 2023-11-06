package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.lotto.LottoCondition.*;

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
    public List<Integer> generateRandomNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(), count);
    }
}
