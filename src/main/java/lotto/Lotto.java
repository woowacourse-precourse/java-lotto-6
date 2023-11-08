package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
