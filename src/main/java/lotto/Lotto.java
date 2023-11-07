package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int countMatchingNumbers(Lotto winningLotto, int bonusNumber) {
        int weight = (int) winningLotto.numbers.stream().filter(this.numbers::contains).count() * 2;
        if (weight >= 10 && this.numbers.contains(bonusNumber)) {
            weight++;
        }
        return weight;
    }

}
