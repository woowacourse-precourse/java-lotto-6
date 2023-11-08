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
            throw new IllegalArgumentException("번호는 6개 입력되어야 합니다.");
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if (numbers.size() != numSet.size()) {
            throw new IllegalArgumentException("중복된 번호는 허용되지 않습니다.");
        }
    }

    public int countMatch(Lotto other) {
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
