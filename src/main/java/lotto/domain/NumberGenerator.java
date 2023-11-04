package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    public static final int NUMBERS_COUNT = 6;

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        addUniqueRandomNumbers(numbers, NUMBERS_COUNT);

        return numbers;
    }

    private void addUniqueRandomNumbers(List<Integer> numbers, int count) {
        while (numbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
