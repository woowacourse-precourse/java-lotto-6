package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 6개를 초과하는 숫자를 입력할 수 없습니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("[")
                .append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            sb.append(", ").append(numbers.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
