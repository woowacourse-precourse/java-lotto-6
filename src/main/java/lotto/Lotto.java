package lotto;

import java.util.Collections;
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
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> setNumber = new HashSet<>(numbers);
        return setNumber.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return numbers;
    }
}
