package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    final int MIN_RANGE_NUMBER = 1;
    final int MAX_RANGE_NUMBER = 45;
    final int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_RANGE_NUMBER, MAX_RANGE_NUMBER, LOTTO_NUMBER_COUNT);
        return numbers;
    }

}
