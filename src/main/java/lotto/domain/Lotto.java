package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int NUMBERS_SIZE = 6;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersValue(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersValue(List<Integer> numbers) {
        for (int number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBERS_SIZE);
    }
}
