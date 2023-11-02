package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("[");

        String numberList = numbers.stream()
                .map(element -> element.toString())
                .collect(Collectors.joining(", "));

        msg.append(numberList).append("]");
        return msg.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 정확히 6자리여야 합니다.");
        }
        for (Integer num : numbers) {
            if (num < 1 || num > 45)
                throw new IllegalArgumentException("각 로또번호는 1 ~ 45 사이의 정수여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
