package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.util.Constant;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(Constant.LOTTO_START_RANGE <= number && number <= Constant.LOTTO_END_RANGE)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> deduplicationSet = new HashSet<>(numbers);
        if (deduplicationSet.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public void printLotto() {
        OutputView.printLotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
