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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
            }

            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
            }

            uniqueNumbers.add(number);
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
