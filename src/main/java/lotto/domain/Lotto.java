package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers
                .stream()
                .map(Number::from)
                .toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private static List<Integer> randomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Integer> sortNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public static Lotto createRandomLotto() {
        List<Integer> intLottos = randomNumber();
        List<Integer> sortLottos = sortNumber(intLottos);
        return new Lotto(sortLottos);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
