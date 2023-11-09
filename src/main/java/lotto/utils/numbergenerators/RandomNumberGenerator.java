package lotto.utils.numbergenerators;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.utils.LottoConstants.*;


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
        return Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_VALUE.getConstants(), LOTTO_MAXIMUM_VALUE.getConstants(), LOTTO_NUMBER_SIZE.getConstants());
    }
}
