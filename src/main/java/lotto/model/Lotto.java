package lotto.model;

import static lotto.util.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public Lotto() {
        this.numbers = randomPickNumbers();
    }

    private static List<Integer> randomPickNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                        LOTTO_MINIMUM_RANGE, LOTTO_MAXIMUM_RANGE, LOTTO_PICK_COUNT)
                .stream().sorted().collect(Collectors.toList());
        return randomNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
