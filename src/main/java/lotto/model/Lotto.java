package lotto;

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
        if (numbers.size() != 6 || !isValidNumbers(numbers) || hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();
        for (int number : numbers) {
            if (!seen.add(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto other = (Lotto) obj;
        return numbers.equals(other.numbers);
    }

}
