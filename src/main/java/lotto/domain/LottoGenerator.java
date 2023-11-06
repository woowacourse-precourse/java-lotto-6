package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> randomNumbers;

    public LottoGenerator() {
        this.randomNumbers = sortRandomNumbers(generateRandomNumbers());
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
    }

    private List<Integer> sortRandomNumbers(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
