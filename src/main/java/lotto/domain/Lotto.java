package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final LottoValidator validator = new LottoValidator();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validator.validateSize(numbers);
        validator.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    public String toString() {
        return String.valueOf(numbers);
    }
}
