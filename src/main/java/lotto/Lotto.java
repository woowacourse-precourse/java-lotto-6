package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.CommandLine.showln;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throwIllegalArgumentException("[ERROR] 로또 번호는 6개 이어야 합니다.");
        }
        if (hasDuplicateNumbers(numbers)) {
            throwIllegalArgumentException("[ERROR] a로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void throwIllegalArgumentException(String message) {
        showln(message);
        throw new IllegalArgumentException(message);
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }
}
