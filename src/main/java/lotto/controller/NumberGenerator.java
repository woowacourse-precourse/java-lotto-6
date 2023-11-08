package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 45;
    private static final int RANDOM_NUMBERS_SIZE = 6;

    public List<Integer> generate() {
        List<Integer> numbers = generateUniqueNumbers();
        return sortNumbers(numbers);
    }

    private List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE,
                RANDOM_NUMBERS_SIZE);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}