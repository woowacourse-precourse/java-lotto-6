package lotto.element;

import java.sql.Array;
import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    int countMatch(Lotto other) {
        List<Integer> otherNumbers = new ArrayList<>(other.getLottoNumbers());
        otherNumbers.retainAll(numbers);
        return otherNumbers.size();
    }

    List<Integer> getLottoNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "["+numbers.get(0)+", "+
                numbers.get(1)+", "+
                numbers.get(2)+", "+
                numbers.get(3)+", "+
                numbers.get(4)+", "+
                numbers.get(5)+"]";
    }
}
