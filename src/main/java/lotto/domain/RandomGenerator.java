package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.ConfigurationNumbers;

public class RandomGenerator {
    private final List<Integer> randomNumbers;

    public RandomGenerator() {
        int minNumber = ConfigurationNumbers.MIN_NUMBER.getNumber();
        int maxNumber = ConfigurationNumbers.MAX_NUMBER.getNumber();
        int lottoLength = ConfigurationNumbers.LOTTO_LENGTH.getNumber();

        randomNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoLength);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
