package lotto.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> errorNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                errorNumbers.add(number);
            }
        }
        if (!errorNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다: " + errorNumbers);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
