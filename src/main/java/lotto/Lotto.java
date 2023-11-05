package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        checkValidation(numbers);
        this.numbers = numbers;
    }

    private void checkValidation(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
        }
        for (Integer number : numbers) {
            new Number(number);
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> numbersWithoutDuplication = new HashSet<>(numbers);
        return numbersWithoutDuplication.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
