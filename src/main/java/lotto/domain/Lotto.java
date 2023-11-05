package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class Lotto {
    private static final int LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateListSize(numbers);
        validateListDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateListSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            ErrorMessage.listSizeError(LOTTO_LENGTH);
            throw new IllegalArgumentException();
        }
    }

    private void validateListDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            ErrorMessage.listDuplicationError();
            throw new IllegalArgumentException();
        }
    }
}