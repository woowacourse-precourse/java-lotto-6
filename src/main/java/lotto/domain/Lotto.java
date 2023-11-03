package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbersOrderByAsc(numbers);
        return new Lotto(numbers);
    }

    private static void numbersOrderByAsc(final List<Integer> numbers) {
        Collections.sort(numbers);
    }

    // getter
    public List<Integer> getNumbers() {
        return numbers;
    }
}
