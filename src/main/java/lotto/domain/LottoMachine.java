package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> randomNumbers;

    public LottoMachine() {
        this.randomNumbers = sortRandomNumbers(generateRandomNumbers());
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
            LOTTO_NUMBER_COUNT);
    }

    private static List<Integer> sortRandomNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

}