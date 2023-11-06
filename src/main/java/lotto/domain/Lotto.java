package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers
                .stream()
                .map(Number::from)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private List<Integer> randomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> sortNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public Lotto createLotto() {
        List<Integer> intLottos = randomNumber();
        List<Integer> sortLottos = sortNumber(intLottos);
        return new Lotto(sortLottos);
    }
}
